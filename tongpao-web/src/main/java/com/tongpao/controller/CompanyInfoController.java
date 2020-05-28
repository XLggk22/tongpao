package com.tongpao.controller;


import com.tongpao.service.ICompanyInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("//company-info")
public class CompanyInfoController {

	@Reference
	private ICompanyInfoService iCompanyInfoService;

}
