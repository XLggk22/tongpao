package com.tongpao.config.auth;

import com.tongpao.util.common.ScanIgnorePathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * 安全配置
 * @author raojing
 * @date 2019/12/2 13:20
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 配置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 用于支持 password 模式
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 获取所有加了 IgnoreTokenAuth 注解的url
        List<String> allIgnoreTokenAuthUrl = ScanIgnorePathUtil.getAllIgnoreTokenAuthUrl("com.tongpao.controller");
        log.info("allIgnoreTokenAuthUrl: {}", allIgnoreTokenAuthUrl);
        web.ignoring()
                .antMatchers(allIgnoreTokenAuthUrl.toArray(new String[]{}));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 解决跨域问题
        http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
    
}
