package com.hui.cloud.auth.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <code>AuthTokenDTO</code>
 * <desc>
 * 描述： 罪过,为了适配oauth2 返回的信息，没用驼峰结构。
 * 而common-model被抽出来,让api模块轻量级，所以没有json的package去使用 @JsonProperty("access_token")
 * <desc/>
 * Creation Time: 2019/9/23 0:36.
 *
 * @author Gary.Hu
 */
@Data
public class AuthTokenDTO implements Serializable {
    private String access_token;

    private String refresh_token;

    private String token_type;

    private Integer expires_in;

    private String scope;

    private String jti;
}
