package com.tongpao.controller;

import com.tongpao.entity.CompanyInfo;
import com.tongpao.service.ICompanyInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: TestController</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 22:47
 */
@RestController
@RequestMapping("/testController")
public class TestController {

	@Reference
	private ICompanyInfoService iCompanyInfoService;

	@GetMapping("/getCompanyById")
	public String getCompanyById(){
		CompanyInfo companyInfo = iCompanyInfoService.getById("111");
		return "hello,result is ====" + companyInfo.toString();
	}
}
