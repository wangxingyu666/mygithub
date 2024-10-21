package top.wangxingyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.wangxingyu.entity.User;
import top.wangxingyu.vo.UserInfoVO;
import top.wangxingyu.vo.UserLoginVO;

/**
 * @author 笼中雀
 */
public interface UserService extends IService<User> {
    UserLoginVO loginByPhone(String phone,String code);

    boolean checkUserEnabled(Long userId);

    UserInfoVO userInfo(Long userId);
}
