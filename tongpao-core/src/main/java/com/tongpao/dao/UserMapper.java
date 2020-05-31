package com.tongpao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tongpao.bo.LoginUserBO;
import com.tongpao.entity.User;

/**
 * <p>
 * 事件记录表 Mapper 接口
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名或手机号码查询用户信息
     *
     * @param account
     * @return
     */
    LoginUserBO findByUserNameOrMobile(String account);
}
