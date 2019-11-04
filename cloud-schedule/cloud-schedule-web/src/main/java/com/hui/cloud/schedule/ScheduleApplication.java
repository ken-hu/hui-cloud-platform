package com.hui.cloud.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <code>ScheduleApplication</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/2 2:48.
 *
 * @author Gary.Hu
 */
@SpringBootApplication(scanBasePackages = "com.hui.cloud")
@EnableDiscoveryClient
@MapperScan("com.hui.cloud.schedule.mapper")
public class ScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }
}
