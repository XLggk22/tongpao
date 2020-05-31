package com.tongpao.config.auth;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import com.tongpao.util.result.WebResponse;
import com.tongpao.util.common.WebResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义token异常信息
 * @author raojing
 * @date 2019/12/6 13:00
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
    
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {

        WebResponse webResponse = null;
        
        Throwable cause = authException.getCause();
        if(cause instanceof InvalidTokenException) {
            webResponse = WebResponseUtil.build("401", "token失效，请重新获取凭证");
        }else{
            webResponse = WebResponseUtil.build("401", "未经授权，不能访问");
        }
        
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.getWriter().write(JSON.toJSONString(webResponse));
    }
    
}
