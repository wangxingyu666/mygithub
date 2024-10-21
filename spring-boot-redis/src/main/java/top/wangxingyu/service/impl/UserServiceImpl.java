package top.wangxingyu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.wangxingyu.cache.TokenStoreCache;
import top.wangxingyu.config.RedisCache;
import top.wangxingyu.config.RedisKeys;
import top.wangxingyu.entity.User;
import top.wangxingyu.enums.AccountStatusEnum;
import top.wangxingyu.enums.ErrorCode;
import top.wangxingyu.exception.ServerException;
import top.wangxingyu.mapper.UserMapper;
import top.wangxingyu.service.UserService;
import top.wangxingyu.utils.JwtUtil;
import top.wangxingyu.vo.UserInfoVO;
import top.wangxingyu.vo.UserLoginVO;

/**
 * @author 笼中雀
 */

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;

    @Override
    public UserLoginVO loginByPhone(String phone,String code){
        String smsCacheKey= RedisKeys.getSmsKey(phone);

        Integer redisCode=(Integer) redisCache.get(smsCacheKey);

        if(ObjectUtils.isEmpty(redisCode)||!redisCode.toString().equals(code)){
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }

        redisCache.delete(smsCacheKey);

        User user=baseMapper.getByPhone(phone);

        if(ObjectUtils.isEmpty(user)){
            log.info("用户不存在，创建用户,phone: {}",phone);
            user=new User();
            user.setNickname(phone);
            user.setPhone(phone);
            user.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.png");
            user.setGender(0);
            user.setEnabled(AccountStatusEnum.ENABLED.getValue());
            user.setBonus(100);
            user.setDeleteFlag(0);
            user.setRemark("这个很懒，什么都没有写");
            baseMapper.insert(user);
        }
        if(!user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue())){
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }

        String accessToken= JwtUtil.createToken(user.getPkId());

        UserLoginVO userLoginVO=new UserLoginVO();
        userLoginVO.setPkId(user.getPkId());
        userLoginVO.setPhone(user.getPhone());
        userLoginVO.setAccessToken(accessToken);
        tokenStoreCache.saveUser(accessToken,userLoginVO);
        return userLoginVO;
    }

    @Override
    public boolean checkUserEnabled(Long userId){
        User user=baseMapper.selectById(userId);
        if(ObjectUtils.isEmpty(user)){
            return false;
        }
        return user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue());
    }

    @Override
    public UserInfoVO userInfo(Long userId){
        User user=baseMapper.selectById(userId);
        if(user==null){
            log.error("用户不存在，userId: {}",userId);
            throw new ServerException(ErrorCode.USER_NOT_EXIST);
        }
        UserInfoVO userInfoVO=new UserInfoVO();
        BeanUtils.copyProperties(user,userInfoVO);
        return userInfoVO;
    }
}
