package com.tongpao.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tongpao.common.WebResponse;
import com.tongpao.common.WebResponseUtil;
import com.tongpao.constant.ApprovalStatusEnum;
import com.tongpao.entity.CompanyInfo;
import com.tongpao.entity.EventRecord;
import com.tongpao.service.ICompanyInfoService;
import com.tongpao.service.IEventRecordService;
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
@RequestMapping("/event-record")
public class EventRecordController {

	@Reference
	private IEventRecordService iEventRecordService;

	@Reference
	private ICompanyInfoService iCompanyInfoService;

	@RequestMapping("/detaill")
	public WebResponse detaill(@RequestParam(value = "id",required = true) String id){
		EventRecord eventRecord = iEventRecordService.getById(id);

		return WebResponseUtil.getSuccessResponse(WebResponseUtil.SUCCESS_MSG,eventRecord);
	}

	@RequestMapping("/saveOrUpdate")
	public WebResponse saveOrUpdate(EventRecord eventRecord){
		//修改后状态边为审核中
		eventRecord.setApprovalStatus(ApprovalStatusEnum.PROCESSING.getCode());
		iEventRecordService.saveOrUpdate(eventRecord);

		return WebResponseUtil.getSuccessResponse();
	}

	/**
	 * 审核
	 * @return
	 */
	@RequestMapping("apppoval")
	public WebResponse apppoval(EventRecord eventRecord){
		//更新事件记录
		iEventRecordService.updateById(eventRecord);
		Wrapper<CompanyInfo> companyInfoWrapper = new QueryWrapper<CompanyInfo>()
				.eq("create_from_event_id",eventRecord.getId());

		//更新或插入公司信息
		CompanyInfo companyInfo = iCompanyInfoService.getOne(companyInfoWrapper);
		if(null == companyInfo){
			companyInfo = new CompanyInfo();
			companyInfo.setCreateFromEventId(eventRecord.getId());
		}
		companyInfo.setCompanyName(eventRecord.getCompanyName());
		companyInfo.setUnifiedCreditCode(eventRecord.getUnifiedCreditCode());
		companyInfo.setCompanyAddress(eventRecord.getCompanyAddress());
		companyInfo.setLegalPerson(eventRecord.getLegalPerson());
		iCompanyInfoService.saveOrUpdate(companyInfo);

		return WebResponseUtil.getSuccessResponse();
	}

}
