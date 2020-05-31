package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.bo.LoginUserBO;
import com.tongpao.dao.UserMapper;
import com.tongpao.entity.User;
import com.tongpao.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 事件记录表 服务实现类
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public LoginUserBO findUserByAccount(String account) {
        return userMapper.findByUserNameOrMobile(account);
    }
}
