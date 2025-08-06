package com.fl.ag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlApiGatewayApplication.class, args);
    }

}
