package com.hui.cloud.auth.service.exception;

import com.hui.cloud.common.exception.BussinessException;

/**
 * <code>AuthException</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/27 23:30.
 *
 * @author Gary.Hu
 */
public class AuthException extends BussinessException {

    public AuthException(String message) {
        super(message);
    }

    public AuthException(int code, String message) {
        super(code, message);
    }

    public AuthException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
