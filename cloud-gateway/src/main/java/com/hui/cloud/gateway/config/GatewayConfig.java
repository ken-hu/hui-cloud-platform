package com.hui.cloud.gateway.config;

import com.hui.cloud.gateway.filter.PermissionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <code>GatewayConfig</code>
 * <desc>
 * 描述：
 * <desc/>
 * <b>Creation Time:</b> 2019/11/4 11:40.
 *
 * @author Gary.Hu
 */
@Configuration
public class GatewayConfig {

    @Bean
    public PermissionFilter permissionFilter(){
        return new PermissionFilter();
    }
}
