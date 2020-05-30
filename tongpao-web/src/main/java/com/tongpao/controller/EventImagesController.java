package com.tongpao.controller;


import com.tongpao.common.WebResponse;
import com.tongpao.common.WebResponseUtil;
import com.tongpao.entity.EventImages;
import com.tongpao.service.IEventImagesService;
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
@RequestMapping("/event-images")
public class EventImagesController {

	@Reference
	private IEventImagesService iEventImagesService;


	@RequestMapping("/detaill")
	public WebResponse detaill(@RequestParam(value = "id",required = true) String id){
		EventImages detail = iEventImagesService.getById(id);

		return WebResponseUtil.getSuccessResponse(WebResponseUtil.SUCCESS_MSG,detail);
	}

	@RequestMapping("/listPage")
	public WebResponse listPage(){
		return null;
	}

	@RequestMapping("/listAll")
	public WebResponse listAll(){
		return null;
	}

}
