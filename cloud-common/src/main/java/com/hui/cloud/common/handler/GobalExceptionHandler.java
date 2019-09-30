/*
 * 广州丰石科技有限公司拥有本软件版权2018并保留所有权利。
 * Copyright 2018, Guangzhou Rich Stone Data Technologies Company Limited,
 * All rights reserved
 */

package com.hui.cloud.common.handler;

import com.hui.cloud.common.exception.BussinessException;
import com.hui.cloud.common.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * <b><code>GobalExceptionHandler</code></b>
 * <p/>
 * Description:
 *  GET方法参数校验可以使用
 *  JSR和Hibernate validator的校验只能对Object的属性进行校验
 *  不能对单个的参数进行校验
 *  spring 在此基础上进行了扩展
 *  添加了MethodValidationPostProcessor拦截器
 *  可以实现对方法参数的校验
 *
 * <p/>
 * <b>Creation Time:</b> 2018/10/29 14:20.
 *
 * @author huweihui
 */
@RestControllerAdvice
@Slf4j
@Order(0)
public class GobalExceptionHandler {

    /**
     * 校验异常处理. 400
     * 配合Hibernate validate 校验Controller传入的BEAN参数
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVO bindResult3ExceptionHandler(MethodArgumentNotValidException e) {
        String message = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage();
        log.error("controller params validate exception ", e);
        return ResponseVO.badRequest(message);
    }


    /**
     * 校验异常处理. 400
     * 配合Hibernate validate 校验GET方法Controller传入的参数
     * @param e the exception result
     * @return the response entity
     * @author : Hu weihui
     * @since hui_project v1
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseVO bindResult2ExceptionHandler(ConstraintViolationException e) {
        String message = ((ConstraintViolationException) e).getConstraintViolations().iterator().next().getMessage();
        log.debug("controller params validate exception ", e);
        return ResponseVO.badRequest(message);
    }

    /**
     * 业务异常 500
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = BussinessException.class)
    public ResponseVO bussinesErrorHandler(BussinessException e) {
        log.error("got a BussinessException ", e);
        return ResponseVO.error(e.getMessage());
    }


    /**
     * 全局异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseVO errorHandler(Exception e) {
        log.error("got a unkonw exception ", e);
        return ResponseVO.error(e.getMessage());
    }


}
