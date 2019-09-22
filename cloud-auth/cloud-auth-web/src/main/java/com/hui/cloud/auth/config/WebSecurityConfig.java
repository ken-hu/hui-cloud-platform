package com.hui.cloud.auth.config;

import com.hui.cloud.auth.handler.AuthLogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * <b><code>WebConfig</code></b>
 * <p/>
 * Web安全配置
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 18:44.
 *
 * @author Gary.Hu
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AuthUserDetailsService authUserDetailsService;


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(authUserDetailsService);
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置忽略的资源
        web.ignoring().antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用 csrf, 由于使用的是JWT，这里不需要csrf
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(((httpServletRequest, httpServletResponse, e) ->
                        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED)))
                .and()
                .authorizeRequests()
                //swagger
                .antMatchers("/swagger-ui.html/**",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/webjars/**")
                .permitAll()
                //oauth token
//                .antMatchers("*")
                .antMatchers("/oauth/*")
                .permitAll()
                .anyRequest().authenticated();
        // 退出登录处理
        http.logout().logoutSuccessHandler(new AuthLogoutHandler());
    }

    /**
     * AuthenticationManager创建bean
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
