package com.hui.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <code>PermissionFilter</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/7 14:37.
 *
 * @author Gary.Hu
 */
public class PermissionFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return null;
    }
}
