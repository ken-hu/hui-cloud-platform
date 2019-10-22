package com.hui.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <code>AuthorizationFilter</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/8 23:00.
 *
 * @author Gary.Hu
 */
public class AuthorizationFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }
}
