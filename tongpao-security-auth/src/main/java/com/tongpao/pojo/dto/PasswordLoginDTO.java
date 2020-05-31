package com.tongpao.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 密码登录-数据传输模型
 *
 * @author raojing
 * @data 2020/5/31 14:28
 */
@Data
public class PasswordLoginDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "账号不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 账号类型
     */
    @NotBlank(message = "账号类型不能为空")
    private String accountType;

}
