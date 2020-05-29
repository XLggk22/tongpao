package com.tongpao.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: ResultDto</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/29 16:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebResponse
{
	//状态
	private String status;

	//信息
	private String msg;

	//是否成功
	private boolean success;

	//数据
	private Object data;

}
