package com.tongpao.bo;

import lombok.Data;

/**
 * 登录用户-业务模型
 *
 * @author raojing
 * @data 2020/5/31 15:19
 */
@Data
public class LoginUserBO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 1-启用 2-禁用
     */
    private Integer status;

}
