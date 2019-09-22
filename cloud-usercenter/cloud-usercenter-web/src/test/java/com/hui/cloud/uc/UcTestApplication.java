package com.hui.cloud.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <code>TestApplication</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/21 0:25.
 *
 * @author Gary.Hu
 */
@SpringBootApplication(scanBasePackages = "com.hui.cloud")
public class UcTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcTestApplication.class, args);
    }
}
