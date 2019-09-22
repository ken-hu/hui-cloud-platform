package com.hui.cloud.uc.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b><code>ResourceRequestType</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2019/3/23 22:37.
 *
 * @author HuWeihui
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum  ResourceRequestType {
    //GET
    GET("GET","HTTP_GET"),
    //POST
    POST("POST","HTTP_POST"),
    //DELETE
    DELETE("DELETE","HTTP_DELETE"),
    //PUT
    PUT("PUT","HTTP_PUT");

    private String code;
    private String name;

}
