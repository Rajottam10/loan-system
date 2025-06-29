package com.fl.sr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer      //tells springboot to create necessary beans for EurekaServer such as; EurekaController, Dashboard etc
public class FlServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlServiceRegistryApplication.class, args);
    }

}
