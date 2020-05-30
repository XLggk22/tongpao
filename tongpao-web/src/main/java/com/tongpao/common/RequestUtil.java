package com.tongpao.common;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: RequestUtil</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/29 22:11
 */
public class RequestUtil {

	/**
	 * 用户登录状态
	 */
	public static final String USER_LOGIN_STATUS_KEY = "USER_LOGIN_STATUS_KEY";

	/**
	 * 用户名key
	 */
	public static final String USER_NAME_KEY = "USER_NAME_KEY";

	/**
	 * 已登录
	 */
	public static final String USER_LOGIN_STATUS_Y = "Y";

	/**
	 * 未登录
	 */
	public static final String USER_LOGIN_STATUS_N = "N";

	/**
	 * 获取当前用户名
	 * @param request
	 * @return
	 */
	public static String getCurrentUserName(HttpServletRequest request){
		String userName = (String) request.getSession().getAttribute(USER_NAME_KEY);
		return userName;
	}

}
