package com.hui.cloud.auth.config;

import com.hui.cloud.auth.oauth.handler.AuthLogoutHandler;
import com.hui.cloud.auth.oauth.handler.AuthWebResponseExceptionHandler;
import com.hui.cloud.auth.oauth.service.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;

/**
 * <b><code>AuthServerConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 22:11.
 *
 * @author Gary.Hu
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 只有配置了该BEAN才能开启密码类型的验证
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthWebResponseExceptionHandler authWebResponseExceptionHandler;
    /**
     * Redis存储Token
     * @return
     */
    @Bean
    public RedisTokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }


    /**
     * 数据库存储Client信息
     * @param dataSource
     * @return
     */
    @Bean
    public ClientDetailsService jdbcClientDetailsService(DataSource dataSource) {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 配置客户端基本信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // clients.withClientDetails(jdbcClientDetailsService(dataSource));
        // 内存数据测试
        clients.inMemory()
                .withClient("android")
                //此处的scopes是无用的，可以随意设置,不填或者为空则默认是所有客户端都可以访问
                .scopes("all")
                .secret(passwordEncoder.encode("android"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .and()
                .withClient("webapp")
                .scopes("all")
                .authorizedGrantTypes("implicit");
    }

    /**
     * 配置授权的基本信息 token，认证管理，用户信息
     * 配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false)
                .userDetailsService(authUserDetailsService)
                //异常处理
                .exceptionTranslator(authWebResponseExceptionHandler);
    }

    /**
     * 配置获取token的策略，获取token的请求不拦截，只需要拦截获取token的验证信息
     * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
        oauthServer.checkTokenAccess("permitAll()")
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
