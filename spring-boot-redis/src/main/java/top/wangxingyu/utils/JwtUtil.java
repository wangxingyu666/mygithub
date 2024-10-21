package top.wangxingyu.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.wangxingyu.constant.Constant;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 笼中雀
 */

@Slf4j
public class JwtUtil {
    private static final String KEY = "hello-world";

    public static String createToken(Long userId) {
        DateTime now = DateTime.now();

        DateTime expTime = now.offsetNew(DateField.HOUR, 48);
        Map<String, Object> payload = new HashMap<>();

        payload.put(RegisteredPayload.ISSUED_AT, now);
        payload.put(RegisteredPayload.EXPIRES_AT, expTime);
        payload.put(RegisteredPayload.NOT_BEFORE, now);

        payload.put(Constant.USER_ID, userId);
        String token = JWTUtil.createToken(payload, KEY.getBytes());
        log.info("生成JWT token: {}", token);
        return token;
    }

    public static boolean validate(String token) {
        try {
            JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
            boolean validate = jwt.validate(0);
            log.info("JWT token 校验结果: {}", validate);
            return validate;
        } catch (Exception e) {
            log.error("JWT token 校验异常: {}", e.getMessage());
            return false;
        }
    }

    public static JSONObject getJSONObject(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
        JSONObject payloads = jwt.getPayloads();
        payloads.remove(RegisteredPayload.ISSUED_AT);
        payloads.remove(RegisteredPayload.EXPIRES_AT);
        payloads.remove(RegisteredPayload.NOT_BEFORE);
        log.info("根据 token 获取原始内容: {}", payloads);
        return payloads;
    }

    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        if (StringUtils.isBlank(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        return accessToken;
    }

    public static void main(String[] args) {
        String token = createToken(10001L);
        System.out.println(token);
        validate(token);
        getJSONObject(token);
    }
}
