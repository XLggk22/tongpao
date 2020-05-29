package com.tongpao.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import com.tongpao.common.WebResponse;
import com.tongpao.common.WebResponseUtil;
import com.tongpao.entity.User;
import com.tongpao.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/29 9:31
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	/**
	 * 用户登录状态
	 */
	private static final String USER_LOGIN_STATUS = "USER_LOGIN_STATUS";

	/**
	 * 已登录
	 */
	private static final String USER_LOGIN_STATUS_Y = "Y";

	/**
	 * 未登录
	 */
	private static final String USER_LOGIN_STATUS_N = "N";

	@Reference
	private IUserService iUserService;

	/**
	 * 获取登录页
	 * @return
	 */
	@RequestMapping("/page")
	public String page(){
		return "login";
	}

	@RequestMapping(value = "/login",method= RequestMethod.POST)
	@ResponseBody
	public WebResponse login(String userName,String password,HttpServletRequest request) {
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			return WebResponseUtil.getFailResponse("用户名不能为空！",null);
		}

		User user = iUserService.getById(userName);

		if (null != user && password.equals(getMd5EncryptedPwd(user.getPassword(),user.getSalt()))){
			request.getSession().setAttribute(USER_LOGIN_STATUS,USER_LOGIN_STATUS_Y);
			return WebResponseUtil.getSuccessResponse();
		}

		return WebResponseUtil.getFailResponse("用户不存在 或 密码错误!");
	}

	@RequestMapping("/register")
	@ResponseBody
	public WebResponse register(String userName,String password,String nickName){
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(nickName)){
			return WebResponseUtil.getFailResponse("信息填写有误！",null);
		}
		User user = iUserService.getById(userName);
		if (null != user){
			WebResponseUtil.getFailResponse("用户名已存在！");
		}
		//设置盐值
		String salt = RandomUtil.randomString(10);
		String encryptedPwd = getMd5EncryptedPwd(user.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(encryptedPwd);
		iUserService.save(user);

		return WebResponseUtil.getSuccessResponse();
	}

	/**
	 * 获取Md5加密密码
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String getMd5EncryptedPwd(String password,String salt){
		return MD5.create().setSalt(salt.getBytes()).digestHex(password);
	}
}
