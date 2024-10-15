package top.wangxingyu.service;

/**
 * @author 笼中雀
 */

import org.springframework.stereotype.Service;
import top.wangxingyu.exception.ServerException;

@Service
public class ExceptionService {
    public void unAuthorizedError(){
        throw new ServerException("没有登录");
    }

    public void systemError(){
        throw new ServerException("系统异常");
    }
}
