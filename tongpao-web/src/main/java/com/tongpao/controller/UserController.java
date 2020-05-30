package com.tongpao.controller;


import com.tongpao.common.RequestUtil;
import com.tongpao.common.WebResponse;
import com.tongpao.common.WebResponseUtil;
import com.tongpao.entity.User;
import com.tongpao.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 事件记录表 前端控制器
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Reference
	private IUserService iUserService;

	@RequestMapping("/page")
	public String page(){
		return "user";
	}

	@RequestMapping("/detaill")
	public WebResponse detaill(HttpServletRequest request){
		String currentUserName = RequestUtil.getCurrentUserName(request);
		User user = iUserService.getById(currentUserName);
		return WebResponseUtil.getSuccessResponse(WebResponseUtil.SUCCESS_MSG,user);
	}

	@RequestMapping("/update")
	public WebResponse update(User user,HttpServletRequest request){
		//校验用户状态
		String currentUserName = RequestUtil.getCurrentUserName(request);
		if (StringUtils.isEmpty(currentUserName) || !currentUserName.equals(user.getUserName())){
			log.info("用户未登录或无修改此数据权限！");
			return WebResponseUtil.getFailResponse("用户未登录或无修改此数据权限！");
		}

		iUserService.updateById(user);
		return WebResponseUtil.getSuccessResponse();
	}
}
