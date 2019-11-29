package com.hui.cloud.common.exception;

/**
 * <b><code>BussinessException</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2019/3/23 22:54.
 *
 * @author HuWeihui
 */

public abstract class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 176810934576819906L;

    private int code;
    private String message;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
