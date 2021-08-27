package com.bingo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

// 注解很重要
@SpringBootApplication
@EnableConfigServer
// @EnableDiscoveryClient 导入依赖后可以省略
public class BscConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BscConfigApplication.class, args);
    }

}
