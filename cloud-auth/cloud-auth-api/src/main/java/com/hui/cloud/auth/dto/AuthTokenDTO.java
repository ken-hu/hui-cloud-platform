package com.hui.cloud.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <code>AuthTokenDTO</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/23 0:36.
 *
 * @author Gary.Hu
 */
@Data
public class AuthTokenDTO implements Serializable {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    private String scope;

    private String jti;
}
