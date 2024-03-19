package com.coderpwh.tsl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author coderpwh
 */
@SpringBootApplication(scanBasePackages = {"com.coderpwh.tsl"})
public class TslApiServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(TslApiServer.class);
    }
}
