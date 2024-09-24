package top.wangxingyu.springboot.configure.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
//@PropertySource("classpath:aliyun-oss.properties")
@ConfigurationProperties(prefix = "aliyun-oss")

public class OssConfig {
    private String endpoint;
    private String bucket;
    private String dir;
    private String host;
    private String ak;
    private String secret;
}
