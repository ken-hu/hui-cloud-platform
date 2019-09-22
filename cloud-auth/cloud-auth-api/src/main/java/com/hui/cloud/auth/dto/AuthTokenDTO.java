package com.hui.cloud.auth.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

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
public class AuthTokenDTO {
    private String accessToken = null;
    private String refreshToken = null;
    private String tokenType = null;
    private Integer expiresIn = null;
    private Integer reExpiresIn = null;
    private Set<String> scope = new HashSet<String>();
}
