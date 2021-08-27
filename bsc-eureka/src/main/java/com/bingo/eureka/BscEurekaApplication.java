package com.bingo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BscEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BscEurekaApplication.class, args);
    }

}
