package com.fl.fcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class FoneloanCentralSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoneloanCentralSystemApplication.class, args);
    }

}
