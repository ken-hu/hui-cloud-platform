package com.hui.cloud.common.model;

import lombok.*;

import java.io.Serializable;

/**
 * <b><code>ResponseVO</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/12 0:15.
 *
 * @author Hu-Weihui
 */
@ToString
@Data
public class ResponseVO<T> implements Serializable {

    private static final long serialVersionUID = 1052605236159056373L;


    private ResponseVO() {
    }

    public ResponseVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Integer code;
    private String msg;
    private T data;


    /**
     * ============================================================================
     * OK
     * ============================================================================
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseVO build(Integer code, String msg, T data) {
        return new ResponseVO(code, msg, data);
    }


    public static <T> ResponseVO ok() {
        return ok(null);
    }

    public static <T> ResponseVO ok(String msg) {
        return ok(msg, null);
    }

    public static <T> ResponseVO ok(T data) {
        return ok(ResponseCons.SUCCESS.msg, data);
    }

    public static <T> ResponseVO ok(String msg, T data) {
        return build(ResponseCons.SUCCESS.code, msg, data);
    }


    /**
     * ============================================================================
     * Error
     * ============================================================================
     *
     * @param <T>
     * @return
     */

    public static <T> ResponseVO error() {
        return error(null);
    }

    public static <T> ResponseVO error(String msg) {
        return error(msg, null);
    }

    public static <T> ResponseVO error(T data) {
        return error(ResponseCons.SERVICE_ERROR.msg, data);
    }

    public static <T> ResponseVO error(String msg, T data) {
        return build(ResponseCons.SERVICE_ERROR.code, msg, data);
    }

    /**
     * ============================================================================
     * FORBIDDEN
     * ============================================================================
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVO forbidden() {
        return forbidden(null);
    }

    public static <T> ResponseVO forbidden(String msg) {
        return forbidden(msg, null);
    }

    public static <T> ResponseVO forbidden(T data) {
        return forbidden(ResponseCons.FORBIDDEN.msg, data);
    }

    public static <T> ResponseVO forbidden(String msg, T data) {
        return build(ResponseCons.FORBIDDEN.code, msg, data);
    }


    /**
     * ============================================================================
     * UNAUTHORIZED
     * ============================================================================
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVO unauthorized() {
        return unauthorized(null);
    }


    public static <T> ResponseVO unauthorized(String msg) {
        return unauthorized(msg, null);

    }

    public static <T> ResponseVO unauthorized(T data) {
        return unauthorized(ResponseCons.UNAUTHORIZED.msg, data);
    }

    public static <T> ResponseVO unauthorized(String msg, T data) {
        return build(ResponseCons.UNAUTHORIZED.code, msg, data);
    }

    /**
     * ============================================================================
     * NOT_FOUND
     * ============================================================================
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVO notFound() {
        return notFound(null);
    }

    public static <T> ResponseVO notFound(String msg) {
        return notFound(msg, null);
    }

    public static <T> ResponseVO notFound(T data) {
        return notFound(ResponseCons.NOT_FOUND.msg, data);
    }

    public static <T> ResponseVO notFound(String msg, T data) {
        return build(ResponseCons.NOT_FOUND.code, ResponseCons.NOT_FOUND.msg, data);
    }


    /**
     * ============================================================================
     * BAD_REQUEST
     * ============================================================================
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVO badRequest() {
        return badRequest(null);
    }

    public static <T> ResponseVO badRequest(String msg) {
        return badRequest(msg, null);
    }

    public static <T> ResponseVO badRequest(T data) {
        return badRequest(ResponseCons.BAD_REQUEST.msg, data);
    }

    public static <T> ResponseVO badRequest(String msg, T data) {
        return build(ResponseCons.BAD_REQUEST.code, ResponseCons.BAD_REQUEST.msg, data);
    }


    @Getter
    @AllArgsConstructor
    public enum ResponseCons {
        /**
         * response 返回通用信息
         */
        SUCCESS(200, "SUCCESS"),
        SERVICE_ERROR(500, "SERVICE_ERROR"),
        BAD_REQUEST(400, "BAD_REQUEST"),
        UNAUTHORIZED(401, "UNAUTHORIZED"),
        FORBIDDEN(403, "FORBIDDEN"),
        NOT_FOUND(404, "NOT_FOUND");

        private int code;
        private String msg;
    }

}
