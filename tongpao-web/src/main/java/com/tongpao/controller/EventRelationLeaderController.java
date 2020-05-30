package com.tongpao.controller;


import com.tongpao.common.WebResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 事件-关联领导表 前端控制器
 * </p>
 *
 * @author rbh
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/event-relation-leader")
public class EventRelationLeaderController {

	@RequestMapping("/listPage")
	public WebResponse listPage(){
		return null;
	}
}
