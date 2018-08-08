package org.hx.controller;

import org.hx.common.service.entity.base.CommonBizException;
import org.hx.common.service.entity.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 业务异常处理
     * @param exception
     * @param <T>
     * @return
     */
    @ExceptionHandler(CommonBizException.class)
    public <T> Result<T> exceptionHandler(CommonBizException exception) {
        return Result.newFailureResult(exception);
    }
    
    /**
     * 系统异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public <T> Result<T> sysExpHandler(Exception exception) {
        logger.error("系统异常 ",exception);
        return Result.newFailureResult();
    }
}
