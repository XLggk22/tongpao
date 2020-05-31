package com.tongpao.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 自定义认证授权
 *
 * @author raojing
 * @date 2020/5/30 22:56
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

//    private final static String ROLE_PREFIX = "ROLE_";
//
//    @Resource
//    private UserPermissionDao userPermissionDao;
//    @Resource
//    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        // 从request域中获取 account_type 用户类型（刷新token 请求会放入 account_type 值），如果不为空，拼接用户名用于区分不同用户类型
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String accountType = request.getParameter("account_type");
//        if(accountType != null){
//            userName = accountType + ":" + userName;
//        }
//        // 规则为：userType:userName
//        String[] userType = userName.split(":", 2);
//        if(userType.length != 2){
//            throw BusinessException.operate("内部错误");
//        }
//        String type = userType[0];
//        userName = userType[1];
//
//        // 通过用户名或手机号码，用户类型查询用户信息
//        LoginUserBO loginUser = userService.findByAccountAndUserType(userName, type);
//        if (loginUser != null) {
//            // 如果用户不是密码登录，修改被security管理的用户密码为 "" 加密串
//            String pwdLogin = request.getParameter("pwdLogin");
//            if(pwdLogin.equals("false")){
//                loginUser.setPassword(UserCommonConstant.DEFAULT_PWD);
//            }
//            // 查询用户权限信息
//            List<UserPermissionBO> permissionList = userPermissionDao.listPermissionByUserId(loginUser.getId());
//
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            permissionList.forEach(item -> {
//
//                String roleCode = item.getRoleCode();
//                if(!roleCode.startsWith(ROLE_PREFIX)){
//                    roleCode = ROLE_PREFIX + roleCode;
//                }
//                // 角色标识
//                SimpleGrantedAuthority roleAuthority = new SimpleGrantedAuthority(roleCode);
//                grantedAuthorities.add(roleAuthority);
//
//                // 权限标识
//                roleAuthority = new SimpleGrantedAuthority(item.getPermissionCode());
//                grantedAuthorities.add(roleAuthority);
//            });
//
//            // 返回用户信息
//            return UserExtend.build(userName, loginUser.getPassword(), loginUser.getStatus() == 1, grantedAuthorities)
//                    .id(loginUser.getId())
//                    .name(loginUser.getUserName())
//                    .phone(loginUser.getPhone())
//                    .wxOpenid(loginUser.getWxOpenid())
//                    .nickName(loginUser.getNickName())
//                    .email(loginUser.getEmail())
//                    .type(type);
//        }else {
//            // 用户名不匹配
//            return null;
//        }
        return null;
    }
}
