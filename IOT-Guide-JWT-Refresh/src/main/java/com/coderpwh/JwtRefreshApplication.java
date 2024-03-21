package com.coderpwh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author coderpwh
 */
@EnableDiscoveryClient
@ServletComponentScan
@MapperScan("com.coderpwh.mapper")
@SpringBootApplication(scanBasePackages = "com.coderpwh")
public class JwtRefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtRefreshApplication.class, args);
    }
}
