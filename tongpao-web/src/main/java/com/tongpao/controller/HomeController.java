package com.tongpao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>Title: HomeController</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/25 11:34
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	//添加一个日志器
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//映射一个action
	@RequestMapping("/index")
	public  String index(){
		//输出日志文件
		logger.info("the first jsp pages");
		//返回一个index.jsp这个视图
		return "index";
	}

	//映射一个action
	@RequestMapping("/date")
	@ResponseBody
	public  String date(){
		//输出日志文件
		logger.info("the first jsp pages1111111111");
		//返回一个index.jsp这个视图
		return "测试时间:2020";
	}
}
