package top.wangxingyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wangxingyu.mapper.UserMapper;
import top.wangxingyu.model.User;
import top.wangxingyu.util.JwtUtils ;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author 笼中雀
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void registerUser(User user) {
        // 使用 BCrypt 对密码进行加密
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userMapper.insertUser(user);
    }

    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            // 生成 JWT Token
            return JwtUtils.generateToken(user.getId());
        }
        return null;
    }

    public User getUserById(int id) {
        // 实现根据 ID 获取用户信息的方法
        // 这里可以直接调用 Mapper 方法
        return null;
    }
}
