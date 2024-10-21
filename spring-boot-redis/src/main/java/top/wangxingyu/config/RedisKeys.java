package top.wangxingyu.config;

/**
 * @author 笼中雀
 * 统一维护Redis中的key
 */


public class RedisKeys {

    //验证码的 key
    public static String getSmsKey(String phone) {
        return "sms:captcha:" + phone;
    }

    public static String getAccessTokenKey(String accessToken){
        return "sys:access:"+accessToken;
    }

    public static String getUserIdKey(Long id){
        return "sys:userId:"+id;
    }
}
