package com.coderpwh.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author coderpwh
 */
@SpringBootApplication(scanBasePackages = {"com.coderpwh.http"})
public class HttpApiServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HttpApiServer.class);
    }


}
