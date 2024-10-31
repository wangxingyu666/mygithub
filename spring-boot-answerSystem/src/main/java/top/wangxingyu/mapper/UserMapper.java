package top.wangxingyu.mapper;

import top.wangxingyu.model.User;

/**
 * @author 笼中雀
 */
public interface UserMapper {

    User findByUsername(String username);
    void insertUser(User user);
    User findById(Integer id);
}
