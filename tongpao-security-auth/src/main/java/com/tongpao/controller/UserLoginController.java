package com.tongpao.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tongpao.annotation.IgnoreTokenAuth;
import com.tongpao.bo.LoginUserBO;
import com.tongpao.constant.common.StateConstants;
import com.tongpao.entity.User;
import com.tongpao.exception.BusinessException;
import com.tongpao.pojo.bo.OauthTokenResponse;
import com.tongpao.pojo.dto.PasswordLoginDTO;
import com.tongpao.service.IUserService;
import com.tongpao.util.common.WebResponseUtil;
import com.tongpao.util.result.WebResponse;
import com.tongpao.vo.LoginSuccessVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 登录管理
 *
 * @author raojing
 * @data 2020/5/30 22:14
 */
@Slf4j
@RestController
public class UserLoginController {

    @Reference
    private IUserService iUserService;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Resource
    private RestTemplate restTemplate;

    @IgnoreTokenAuth
    @PostMapping("/login/pwd")
    public WebResponse loginPwd(@Valid @RequestBody PasswordLoginDTO passwordLoginDTO) {
        String username = passwordLoginDTO.getUsername();
        String accountType = passwordLoginDTO.getAccountType();

        Wrapper<User> userWrapper = new QueryWrapper<User>()
                .eq("user_name", username);

        User one = iUserService.getOne(userWrapper);

        LoginUserBO loginUserBO = new LoginUserBO();
        BeanUtils.copyProperties(one, loginUserBO);

//        LoginUserBO loginUserBO = iUserService.findUserByAccount(passwordLoginDTO.getUsername());
        if (null == loginUserBO) {
            throw BusinessException.operate("账号不存在");
        }

        if (!loginUserBO.getStatus().equals(StateConstants.STATE_ENABLE)) {
            throw BusinessException.operate("账号不可用");
        }
        if (!passwordEncoder.matches(passwordLoginDTO.getPassword(), loginUserBO.getPassword())) {
            throw BusinessException.operate("密码错误，请重新输入");
        }
        LoginSuccessVO loginSuccessVO = requestAccessToken(buildLoginParam(accountType, username, passwordLoginDTO.getPassword(), true));
        return WebResponseUtil.getSuccessResponse(loginSuccessVO);
    }

    /**
     * 获取 access_token
     *
     * @param requestParam
     * @return
     */
    private LoginSuccessVO requestAccessToken(MultiValueMap<String, String> requestParam) {
        String url = "http://localhost:8003/auth/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestParam, headers);
        try {
            OauthTokenResponse response = restTemplate.postForObject(url, request, OauthTokenResponse.class);
            return LoginSuccessVO.builder()
                    .accessToken(response.getAccess_token())
                    .build();
        } catch (Exception e) {
            log.info("授权失败:{}", e.getMessage());
            throw BusinessException.operate("账号不可用");
        }
    }

    /**
     * 构建登录请求参数
     *
     * @param accountType
     * @param userName
     * @param password
     * @param pwdLogin
     * @return
     */
    private MultiValueMap<String, String> buildLoginParam(String accountType, String userName, String password, boolean pwdLogin) {
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("username", userName);
        param.add("password", password);
        param.add("grant_type", "password");
        param.add("client_id", "client");
        param.add("client_secret", "secret");
        // 刷新token的用户类型
        param.add("account_type", accountType);
        // 是否密码登录
        param.add("pwdLogin", pwdLogin ? "true" : "false");
        return param;
    }

}
