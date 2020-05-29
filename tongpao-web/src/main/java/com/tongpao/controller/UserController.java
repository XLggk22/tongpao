package com.tongpao.controller;


import com.tongpao.common.WebResponse;
import com.tongpao.common.WebResponseUtil;
import com.tongpao.entity.User;
import com.tongpao.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {

	@Reference
	private IUserService iUserService;

	@RequestMapping("/page")
	public String page(){
		return "user";
	}

	@RequestMapping("/detaill")
	public WebResponse detaill(@RequestParam(value = "userName",required = true) String userName){
		User user = iUserService.getById(userName);
		return WebResponseUtil.getSuccessResponse(WebResponseUtil.SUCCESS_MSG,user);
	}

	@RequestMapping("/update")
	public WebResponse update(User user){
		iUserService.updateById(user);
		return WebResponseUtil.getSuccessResponse();
	}
}
