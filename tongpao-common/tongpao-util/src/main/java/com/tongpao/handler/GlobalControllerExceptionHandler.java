/*
 * Created by: xwc
 * Date: 2018
 * e-mail: xwencong@163.com
 */

package com.tongpao.handler;

import com.tongpao.exception.BusinessException;
import com.tongpao.exception.BusinessMessage;
import com.tongpao.util.result.WebResponse;
import com.tongpao.util.common.WebResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author raojing
 * @date 2019/11/15 12:37
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * 业务异常处理器
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(BusinessException.class)
    public WebResponse businessExceptionHandler(BusinessException e) {
        log.info("BusinessException ---> {}", e.getMessage());
        BusinessMessage businessMessage = e.getBusinessMessage();
        return WebResponseUtil.build(businessMessage.getCode(), businessMessage.getMsg());
    }

    /**
     * 其他异常处理器
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(Exception.class)
    public WebResponse defaultExceptionHandler(Exception e) {
        log.info("Exception ---> {}", e.getMessage());
        return WebResponseUtil.getFailResponse().msg("系统异常，请稍后重试");
    }
    
    /**
     * 处理请求方式错误引起的异常
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public WebResponse errorRequestMethod(HttpRequestMethodNotSupportedException e) {
        log.info("HttpRequestMethodNotSupportedException ---> {}", e.getMessage());
        return WebResponseUtil.getFailResponse().msg(e.getMessage());
    }

}
