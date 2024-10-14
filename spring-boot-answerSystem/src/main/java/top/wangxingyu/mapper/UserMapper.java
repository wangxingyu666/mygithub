package top.wangxingyu.mapper;


import org.apache.ibatis.annotations.Select;
import top.wangxingyu.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 笼中雀
 */
@Mapper
public interface UserMapper {
    //@Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    void insertUser(User user);
}
