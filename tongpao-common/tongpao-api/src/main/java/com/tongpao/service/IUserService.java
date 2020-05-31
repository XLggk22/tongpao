package com.tongpao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tongpao.bo.LoginUserBO;
import com.tongpao.entity.User;

/**
 * <p>
 * 事件记录表 服务类
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
public interface IUserService extends IService<User> {

    /**
     * 根据账号查询用户信息
     *
     * @param account
     * @return
     */
    LoginUserBO findUserByAccount(String account);

}
