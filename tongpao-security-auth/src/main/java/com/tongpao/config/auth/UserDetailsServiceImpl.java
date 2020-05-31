package com.tongpao.config.auth;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tongpao.bo.LoginUserBO;
import com.tongpao.entity.User;
import com.tongpao.exception.BusinessException;
import com.tongpao.pojo.bo.UserExtend;
import com.tongpao.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义认证授权
 *
 * @author raojing
 * @date 2020/5/30 22:56
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static String ROLE_PREFIX = "ROLE_";

    @Reference
    private IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // 从request域中获取 account_type 用户类型（刷新token 请求会放入 account_type 值），如果不为空，拼接用户名用于区分不同用户类型
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String accountType = request.getParameter("account_type");
        if(accountType != null){
            userName = accountType + ":" + userName;
        }
        // 规则为：userType:userName
        String[] userType = userName.split(":", 2);
        if(userType.length != 2){
            throw BusinessException.operate("内部错误");
        }
        String type = userType[0];
        userName = userType[1];

        // 通过用户名或手机号码，用户类型查询用户信息
//        LoginUserBO loginUser = iUserService.findUserByAccount(userName);

        Wrapper<User> userWrapper = new QueryWrapper<User>()
                .eq("user_name", userName);

        User one = iUserService.getOne(userWrapper);

        LoginUserBO loginUser = new LoginUserBO();
        BeanUtils.copyProperties(one, loginUser);

        if (loginUser != null) {
            // 查询用户权限信息 todo
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            SimpleGrantedAuthority roleAuthority = new SimpleGrantedAuthority("visitor");
            grantedAuthorities.add(roleAuthority);


            // 返回用户信息
            return UserExtend.build(userName, loginUser.getPassword(), loginUser.getStatus() == 1, grantedAuthorities)
                    .id(loginUser.getId())
                    .name(loginUser.getUserName())
                    .phone(loginUser.getMobile())
                    .nickName(loginUser.getNickname())
                    .email(loginUser.getEmail())
                    .type(type);
        }else {
            // 用户名不匹配
            return null;
        }
    }
}
