package com.hui.cloud.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * <b><code>UcApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/13 1:19.
 *
 * @author Hu-Weihui
 */
@SpringBootApplication(scanBasePackages = {"com.hui.cloud"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hui.cloud")
@MapperScan("com.hui.cloud.uc.mapper")
@EnableOAuth2Client
public class UcApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcApplication.class, args);
    }
}
