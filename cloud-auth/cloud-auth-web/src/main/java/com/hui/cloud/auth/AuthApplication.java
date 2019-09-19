package com.hui.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
@EnableFeignClients(basePackages = "com.hui.cloud")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
