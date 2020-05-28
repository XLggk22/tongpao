package com.tongpao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tongpao.dao.UserMapper;
import com.tongpao.entity.User;
import com.tongpao.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 事件记录表 服务实现类
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
