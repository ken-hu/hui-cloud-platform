package com.hui.cloud.uc.exception;

import com.hui.cloud.common.exception.BusinessException;

/**
 * <code>SysUserException</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/1 10:47.
 *
 * @author Gary.Hu
 */
public class SysUserException extends BusinessException {
    public SysUserException(String message) {
        super(message);
    }

    public SysUserException(int code, String message) {
        super(code, message);
    }

    public SysUserException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
