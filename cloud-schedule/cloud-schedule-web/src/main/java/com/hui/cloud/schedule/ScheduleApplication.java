package com.hui.cloud.schedule;

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
@SpringBootApplication
@EnableDiscoveryClient
public class ScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);

    }
}
