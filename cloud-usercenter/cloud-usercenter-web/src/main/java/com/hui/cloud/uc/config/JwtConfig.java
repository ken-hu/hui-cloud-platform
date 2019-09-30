package com.hui.cloud.uc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * <code>JwtConfig</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/1 1:56.
 *
 * @author Gary.Hu
 */
@Configuration
public class JwtConfig {
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        //用作 JWT 转换器
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("public-key");
        return converter;
    }
}
