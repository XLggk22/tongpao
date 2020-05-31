package com.tongpao.controller;

import com.tongpao.pojo.dto.PasswordLoginDTO;
import com.tongpao.service.IUserService;
import com.tongpao.util.WebResponse;
import com.tongpao.util.WebResponseUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录管理
 *
 * @author raojing
 * @data 2020/5/30 22:14
 */
@RestController
public class UserLoginController {

    @Reference
    private IUserService iUserService;

    @PostMapping("/login/member")
    public WebResponse loginMember(@Valid @RequestBody PasswordLoginDTO passwordLoginDTO){

        return WebResponseUtil.getSuccessResponse();
    }

}
