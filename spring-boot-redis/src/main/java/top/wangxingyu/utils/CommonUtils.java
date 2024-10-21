package top.wangxingyu.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 笼中雀
 */


public class CommonUtils {
    //生成四位随机整数验证码
    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);

    }
}
