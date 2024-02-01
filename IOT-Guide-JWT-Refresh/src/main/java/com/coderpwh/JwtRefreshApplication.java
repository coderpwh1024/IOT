package com.coderpwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author coderpwh
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.coderpwh")
public class JwtRefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtRefreshApplication.class, args);
    }
}
