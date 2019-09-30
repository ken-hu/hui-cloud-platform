/*
package com.hui.cloud.uc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.servlet.http.HttpServletResponse;

*/
/**
 * <code>AuthResourceServerConfig</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/26 23:18.
 *
 * @author Gary.Hu
 *//*

@Configuration
@EnableResourceServer
public class AuthResourceServerConfig extends ResourceServerConfigurerAdapter {

    private String publicKey = "public-key";

    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public AuthResourceServerConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean(name = "jwtAccessTokenConverter")
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(publicKey);
        return converter;
    }

    */
/**
     * Redis存储Token
     *
     * @return
     *//*

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
//        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request,response,authException)-> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers("/sys-user/users","/sys-user/login","/sys-user/register","/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .anonymous().disable();
        super.configure(http);
    }
}
*/
