package top.wangxingyu.filter_interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.util.UUID;

/**
 * @author 笼中雀
 */
@Component
@Slf4j
public class UploadImageInterceptor implements HandlerInterceptor {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    private static final long MAX_FILE_SIZE = 2 * 1024 * 1024;
    private static final int MAX_WIDTH = 1920;
    private static final int MAX_HEIGHT = 1080;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始处理请求: {}", request.getRequestURI());

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");

            if (file != null) {
                // 文件大小检查
                long fileSize = file.getSize();
                log.info("上传文件大小: {} bytes", fileSize);
                if (fileSize > MAX_FILE_SIZE) {
                    log.error("上传文件大小超出限制: {} bytes", fileSize);
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "上传文件大小超出限制，请上传小于 2MB 的文件。");
                    return false;
                }

                // 文件类型检查
                if (!isValidFileType(file)) {
                    log.info("无效的文件类型: {}", file.getContentType());
                    response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid file type");
                    return false;
                }

                // 图片尺寸检查
                BufferedImage img = ImageIO.read(file.getInputStream());
                if (img.getWidth() > MAX_WIDTH || img.getHeight() > MAX_HEIGHT) {
                    log.info("图片尺寸超出限制: {}x{}，最大限制: {}x{}", img.getWidth(), img.getHeight(), MAX_WIDTH, MAX_HEIGHT);
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Image size exceeds limit");
                    return false;
                }

                // 添加水印
                BufferedImage watermarkedImage = addWatermark(img);

                // 生成唯一文件名
                String objectName = UUID.randomUUID() + "-" + file.getOriginalFilename();

                // 上传到阿里云 OSS
                uploadFileToOSS(objectName, watermarkedImage);
                log.info("文件上传成功: {}", objectName);
            } else {
                log.warn("未找到文件");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "File not found");
                return false;
            }
        } else {
            log.warn("请求不是MultipartHttpServletRequest");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Request is not multipart");
            return false;
        }

        String path = request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        log.info("请求已经到达拦截器：path:{}, clientIp:{}, beginTime:{}", path, clientIp, LocalDateTime.now());
        return true;
    }

    private boolean isValidFileType(MultipartFile file) {
        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf('.') + 1).toLowerCase() : "";

        log.info("文件名: {}, MIME类型: {}, 扩展名: {}", originalFilename, contentType, extension);

        return switch (extension) {
            case "png" -> contentType.equals("image/png");
            case "jpg", "jpeg" -> contentType.equals("image/jpeg") || contentType.equals("application/octet-stream");
            case "gif" -> contentType.equals("image/gif");
            default -> false;
        };
    }

    private BufferedImage addWatermark(BufferedImage source) {
        BufferedImage watermarked = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) watermarked.getGraphics();
        g2d.drawImage(source, 0, 0, null);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(new Color(255, 0, 0, 128));
        g2d.drawString("image", 10, 30);
        g2d.dispose();
        return watermarked;
    }

    private void uploadFileToOSS(String objectName, BufferedImage img) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            File tempFile = File.createTempFile("upload-", objectName);
            ImageOutputStream ios = ImageIO.createImageOutputStream(tempFile);
            ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
            ImageWriteParam param = writer.getDefaultWriteParam();
            writer.setOutput(ios);
            writer.write(null, new IIOImage(img, null, null), param);
            ios.close();

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, tempFile);
            ossClient.putObject(putObjectRequest);
            log.info("文件上传成功: {}", objectName);
            tempFile.delete();
        } finally {
            ossClient.shutdown();
        }
    }
}

