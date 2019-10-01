package com.hui.cloud.uc.vo;

import lombok.Data;

/**
 * <code>LoginUserDTO</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/1 10:49.
 *
 * @author Gary.Hu
 */
@Data
public class LoginUserVO {
    private String userName;

    private Long userId;

    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private Integer expiresIn;

    private String scope;

    private String jti;
}
