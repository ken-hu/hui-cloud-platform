package com.hui.cloud.common.handler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <code>GlobalRedisLock</code>
 * <desc>
 * 描述：
 * <desc/>
 * <b>Creation Time:</b> 2019/11/29 16:46.
 *
 * @author Gary.Hu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalRedisLock {
    String key();

    long waitTime() default -1;
}
