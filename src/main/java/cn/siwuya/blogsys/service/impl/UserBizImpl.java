package cn.siwuya.blogsys.service.impl;

import cn.siwuya.blogsys.common.ServiceException;
import cn.siwuya.blogsys.dao.IUserMapper;
import cn.siwuya.blogsys.entity.UserEntity;
import cn.siwuya.blogsys.service.IUserBiz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登录/注销
 * @author shi_dd
 * @date 2020/7/10 14:11
 */
@Service
public class UserBizImpl implements IUserBiz {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public String login(String username, String password) {
        UserEntity user = userMapper.login(username,password);
        if(user == null){
            throw  new ServiceException("用户名或密码错误");
        }
        return  "login ok";
    }
}
