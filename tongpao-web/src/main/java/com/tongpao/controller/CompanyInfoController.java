package com.tongpao.controller;


import com.tongpao.common.WebResponse;
import com.tongpao.common.WebResponseUtil;
import com.tongpao.entity.CompanyInfo;
import com.tongpao.service.ICompanyInfoService;
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
@RequestMapping("/company-info")
public class CompanyInfoController {

	@Reference
	private ICompanyInfoService iCompanyInfoService;

	@RequestMapping("/page")
	public String page(){
		return "login";
	}

	@RequestMapping("/detaill")
	public WebResponse detaill(@RequestParam(value = "id",required = true) String id){
		CompanyInfo companyInfo = iCompanyInfoService.getById(id);

		return WebResponseUtil.getSuccessResponse(WebResponseUtil.SUCCESS_MSG,companyInfo);
	}

	@RequestMapping("/listPage")
	public WebResponse listPage(){
		return null;
	}
}
