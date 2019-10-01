package com.hui.cloud.auth.config;

import com.hui.cloud.auth.service.impl.AuthUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * <b><code>WebConfig</code></b>
 * <p/>
 * Web安全配置 , 因为OAuth服务也需要被保护
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 18:44.
 *
 * @author Gary.Hu
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    /**
     * 开启用户密码认证
     * 也就是说客户端除了带上client的信息外，还要带上用户信息
     *
     * @return
     * @throws Exception
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * 密码加密器
     *
     * @return
     */
    @Bean(name = "passwordEncoder")
    @Qualifier(value = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 密码配置
        auth.userDetailsService(authUserDetailsService).passwordEncoder(passwordEncoder());
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //允许这些资源访问
        web.ignoring()
                // swagger 放行
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/**")
                .antMatchers("/actuator/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http       //关闭CSRF,使用的是JWT，这里不需要csrf
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    log.error(authException.getMessage(), authException);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                })
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .anonymous().disable();
    }

}
