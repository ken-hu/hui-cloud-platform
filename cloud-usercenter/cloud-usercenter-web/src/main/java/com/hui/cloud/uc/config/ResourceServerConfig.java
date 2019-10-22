package com.hui.cloud.uc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * <code>ResourceServerConfig</code>
 * <desc>
 * 描述：资源服务配置
 * <desc/>
 * Creation Time: 2019/10/1 1:38.
 *
 * @author Gary.Hu
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private TokenStore tokenStore;

    @Autowired
    public ResourceServerConfig(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //swagger放行
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/**").permitAll()
                .antMatchers("/usercenter-service/**").permitAll()
                //允许登录、注册放行
                .antMatchers("/sys-user/user","/sys-user/login","/sys-user/register","/h2-console").permitAll()
                // 健康检查放行
                .antMatchers("/actuator/**").permitAll()
                //OPTIONS请求 放行
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .tokenStore(tokenStore)
                // 设置资源ID
                .resourceId("usercenter-service");
    }
}
