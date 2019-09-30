package com.hui.cloud.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b><code>AuthApplication</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2019/9/18 16:43.
 *
 * @author Gary.Hu
 */
@SpringBootApplication(scanBasePackages ="com.hui.cloud.auth")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hui.cloud")
@MapperScan("com.hui.cloud.auth.mapper")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
