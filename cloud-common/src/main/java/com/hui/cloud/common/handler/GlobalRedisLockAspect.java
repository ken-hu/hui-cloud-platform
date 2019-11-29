package com.hui.cloud.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <code>GlobalRedisLockAspect</code>
 * <desc>
 * 描述：
 * <desc/>
 * <b>Creation Time:</b> 2019/11/29 16:43.
 *
 * @author Gary.Hu
 */
@Component
@Aspect
@Slf4j
public class GlobalRedisLockAspect {

    @Around("@annotation(com.hui.cloud.common.handler.GlobalRedisLock)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AnnotationUtils.findAnnotation(method, GlobalRedisLock.class);

        // 拿锁 .... 释放锁.....
        return null;
    }
}
