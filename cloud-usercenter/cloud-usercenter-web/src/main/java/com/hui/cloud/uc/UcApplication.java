package com.hui.cloud.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b><code>UcApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/13 1:19.
 *
 * @author Hu-Weihui
 */
@SpringBootApplication(scanBasePackages = {"com.hui.cloud.uc"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hui.cloud")
@MapperScan("com.hui.cloud.uc.mapper")
public class UcApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcApplication.class, args);
    }
}
