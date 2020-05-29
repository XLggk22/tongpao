package com.tongpao.controller;

import com.tongpao.entity.CompanyInfo;
import com.tongpao.service.ICompanyInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: TestController</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 22:47
 */
@Controller
@RequestMapping("/testController")
@Slf4j
public class TestController {

	@Reference
	private ICompanyInfoService iCompanyInfoService;

	@GetMapping("/getCompanyById")
	public String getCompanyById(){
		CompanyInfo companyInfo = iCompanyInfoService.getById("111");
		return "hello,result is ====" + companyInfo.toString();
	}
	//添加一个日志器

	//映射一个action
	@RequestMapping("/testHtml")
	public  String index(ModelMap map){
		//输出日志文件
		log.info("the first jsp pages");
		//数据
		map.addAttribute("temp","new出蕾姆！");
		//返回一个index.jsp这个视图
		return "TestHtml";
	}

	//映射一个action
	@RequestMapping("/date")
	@ResponseBody
	public  String date(){
		//输出日志文件
		log.info("the first jsp pages1111111111");
		//返回一个index.jsp这个视图
		return "测试时间:2020";
	}
}
