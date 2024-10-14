package top.wangxingyu.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wangxingyu.entity.User;
import top.wangxingyu.mapper.UserMapper;

import java.util.List;

/**
 * @author 笼中雀
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public boolean createUser(User user){
        return this.save(user);
    }

    public boolean updateUser(User user){
        return this.updateById(user);
    }

    public boolean deleteUserById(Long id){
        return this.removeById(id);
    }

    public User getUserById(Long id){
        return this.getById(id);
    }

    public List<User> getUsersByName(String name){
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(User::getName,name).eq(User::getDeleted,0);
        return this.list(queryWrapper);
    }

    public Page<User> getUserByPage(int currentPage,int pageSize){
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getDeleted,0);
        return this.page(new Page<>(currentPage,pageSize),queryWrapper);
    }

}
