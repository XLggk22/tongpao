package com.tongpao.util.common;

import com.tongpao.exception.DefaultSuccessMsgEnum;
import com.tongpao.exception.ErrorMsgEnum;
import com.tongpao.util.result.WebResponse;

/**
 * <p>Title: WebResponseUtil</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/29 16:15
 */
public class WebResponseUtil {

    private static DefaultSuccessMsgEnum successMsgEnum = DefaultSuccessMsgEnum.SUCCESS;
    private static ErrorMsgEnum errorMsgEnum = ErrorMsgEnum.FAIL;

    /**
     * 操作成功响应
     *
     * @return
     */
    public static WebResponse getSuccessResponse() {
        return getSuccessResponse(successMsgEnum.getMsg(), null);
    }

    public static<T> WebResponse getSuccessResponse(T data) {
        return getSuccessResponse(successMsgEnum.getMsg(), data);
    }

    public static<T> WebResponse getSuccessResponse(String msg, T data) {
        return new WebResponse(successMsgEnum.getCode(), msg, true, data);
    }

    /**
     * 操作失败响应
     *
     * @return
     */
    public static WebResponse getFailResponse() {
        return getFailResponse(errorMsgEnum.getMsg(), null);
    }

    public static<T> WebResponse getFailResponse(String msg, T data) {
        return new WebResponse(errorMsgEnum.getCode(), msg, false, data);
    }

    public static WebResponse build(String code, String msg){
        return new WebResponse(code, msg, false, null);
    }

}
