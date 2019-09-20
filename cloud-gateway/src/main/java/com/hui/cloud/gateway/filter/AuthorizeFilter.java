package com.hui.cloud.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <code>AuthorizeFilter</code>
 * <desc>
 * 描述： 全局
 * <desc/>
 * <b>Creation Time:</b> 2019/9/20 18:31.
 *
 * @author Gary.Hu
 */
@Component
@Order(0)
public class AuthorizeFilter implements GlobalFilter {

    private static final String AUTHORIZE_TOKEN = "authorize_token";
    private static final String AUTHORIZE_USERID = "authorize_userid";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // Request处理
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String authorizeToken = headers.getFirst(AUTHORIZE_TOKEN);
        String userId = headers.getFirst(AUTHORIZE_USERID);

        // Respnse处理
        ServerHttpResponse response = exchange.getResponse();

        // 1.校验是否有带token
        if (StringUtils.isEmpty(authorizeToken) || StringUtils.isEmpty(userId)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        // 2.校验token是否允许访问
        //TODO 这里预计是用MAP做redis的访问控制
        String authToken = stringRedisTemplate.opsForValue().get(userId);
        if (authToken == null || !authToken.equals(authorizeToken)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }
}
