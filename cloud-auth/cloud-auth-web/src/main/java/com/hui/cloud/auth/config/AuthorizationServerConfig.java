package com.hui.cloud.auth.config;

import com.hui.cloud.auth.handler.AuthLogoutHandler;
import com.hui.cloud.auth.handler.AuthWebResponseExceptionHandler;
import com.hui.cloud.auth.service.impl.AuthClientDetailsService;
import com.hui.cloud.auth.service.impl.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;

/**
 * <b><code>AuthServerConfig</code></b>
 * <p/>
 * 授权服务配置
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 22:11.
 *
 * @author Gary.Hu
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 只有配置了该BEAN才能开启密码类型的验证
     */
    private AuthenticationManager authenticationManager;

    private AuthClientDetailsService authClientDetailsService;

    private AuthUserDetailsService authUserDetailsService;

    private RedisConnectionFactory redisConnectionFactory;

    private AuthWebResponseExceptionHandler authWebResponseExceptionHandler;

    private PasswordEncoder passwordEncoder;

    private String publicKey = "public-key";

    private DataSource dataSource;

    @Autowired
    public AuthorizationServerConfig(AuthenticationManager authenticationManager,
                                     AuthClientDetailsService authClientDetailsService,
                                     AuthUserDetailsService authUserDetailsService,
                                     RedisConnectionFactory redisConnectionFactory,
                                     AuthWebResponseExceptionHandler authWebResponseExceptionHandler,
                                      PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.authenticationManager = authenticationManager;
        this.authClientDetailsService = authClientDetailsService;
        this.authUserDetailsService = authUserDetailsService;
        this.redisConnectionFactory = redisConnectionFactory;
        this.authWebResponseExceptionHandler = authWebResponseExceptionHandler;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }


    @Bean(name = "jwtAccessTokenConverter")
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(publicKey);
        return converter;
    }

    /**
     * Redis存储Token
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 配置客户端基本信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(authClientDetailsService);
         //内存数据测试
        clients.inMemory()
                .withClient("usercenter-service")
                //此处的scopes是无用的，可以随意设置,不填或者为空则默认是所有客户端都可以访问
                .scopes("all")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token");
    }

    /**
     * 配置授权的基本信息 token，认证管理，用户信息
     * 配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //使用jwttoken无状态形式保存认证信息
                .tokenEnhancer(tokenEnhancer())
                //token 存储
                .tokenStore(tokenStore())
                //启用auth user password授权方式
                .authenticationManager(authenticationManager)
//                .reuseRefreshTokens(false)
                //refresh_token授权方式需要指定UserDetailsService
                .userDetailsService(authUserDetailsService)
                //异常处理
                .exceptionTranslator(authWebResponseExceptionHandler)
                // 设置客户端可以使用get和post方式提交
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    /**
     * 配置获取token的策略，获取token的请求不拦截，只需要拦截获取token的验证信息
     * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     *
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                //设置ClientSecret密码加密编码方式
                .passwordEncoder(passwordEncoder)
                //获取token的请求，不进行拦截
                .tokenKeyAccess("permitAll()")
                //检查token的请求，要先通过验证
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 退出时的处理策略配置
     *
     * @return logout success handler
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new AuthLogoutHandler();
    }
}
