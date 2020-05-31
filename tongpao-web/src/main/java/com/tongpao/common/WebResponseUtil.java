package com.tongpao.common;

/**
 * <p>Title: WebResponseUtil</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/29 16:15
 */
public class WebResponseUtil {

	public static final String SUCCESS_STATUS = "200";

	public static final String FAIL_STATUS = "500";

	public static final String SUCCESS_MSG = "操作成功！";

	public static final String FAIL_MSG = "操作失败！";

	/**
	 * 操作成功响应
	 * @return
	 */
	public static WebResponse getSuccessResponse(){
		return getSuccessResponse(SUCCESS_MSG,null);
	}

	public static WebResponse getSuccessResponse(String msg){
		return getSuccessResponse(msg,null);
	}

	public static WebResponse getSuccessResponse(String msg,Object data){
		return new WebResponse(SUCCESS_STATUS,msg,true,data);
	}

	/**
	 *  操作失败响应
	 * @return
	 */
	public static WebResponse getFailResponse(){
		return getFailResponse(FAIL_MSG,null);
	}

	public static WebResponse getFailResponse(String msg){
		return getFailResponse(msg,null);
	}

	public static WebResponse getFailResponse(String msg,Object data){
		return new WebResponse(FAIL_STATUS,msg,false,data);
	}
}
