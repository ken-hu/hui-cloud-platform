package com.hui.cloud.auth.service.impl;

import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.stereotype.Component;

/**
 * <code>AuthOauthCode</code>
 * <desc>
 * <p>
 * <desc/>
 * Creation Time: 2019/9/20 0:23.
 *
 * @author Gary.Hu
 */
@Component
public class AuthCodeService implements AuthorizationCodeServices {
    @Override
    public String createAuthorizationCode(OAuth2Authentication authentication) {
        return null;
    }

    @Override
    public OAuth2Authentication consumeAuthorizationCode(String code) throws InvalidGrantException {
        return null;
    }
}
