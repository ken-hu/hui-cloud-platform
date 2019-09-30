package com.hui.cloud.auth.config;

import com.hui.cloud.auth.service.impl.AuthUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //允许这些资源访问
        web.ignoring().antMatchers()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**","/webjars/**","/v2/**")
                .antMatchers("/actuator/**")
                .antMatchers("/test", "/auth-service/oauth/token", "/sys-user/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用 csrf, 由于使用的是JWT，这里不需要csrf
        http.cors().and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //异常处理
                .exceptionHandling()
                .authenticationEntryPoint(((httpServletRequest, httpServletResponse, e) ->{
                    log.info(e.getMessage(),e);
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                        }
                        ))
                .and()
                .authorizeRequests()
                .antMatchers("/test","/auth-service/oauth/token","/oauth/**","/sys-user/**")
                .permitAll()
                //swagger
                .antMatchers("/swagger-ui.html/**",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/webjars/**","/actuator/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .anonymous().disable();
//                .defaultSuccessUrl("/");
        // 退出登录处理
//        http.logout().logoutSuccessHandler(new AuthLogoutHandler());
    }

}
