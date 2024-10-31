package top.wangxingyu.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wangxingyu.mapper.UserMapper;
import top.wangxingyu.model.User;
import top.wangxingyu.util.JwtUtils;

/**
 * @author 笼中雀
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void registerUser(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userMapper.insertUser(user);
    }


    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            String token = JwtUtils.generateToken(user.getId());
            System.out.println("Generated token: " + token);
            return token;
        }
        return null;
    }
    public User getUserById(int id) {
        return userMapper.findById(id);
    }
}
