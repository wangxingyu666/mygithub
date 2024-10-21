package top.wangxingyu.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 笼中雀
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wxy.sms.ccp")
public class CloopenConfig {
    private String serverIp;
    private String port;
    private String accountSId;
    private String  accountToken;
    private  String appId;
    private String templateId;
}
