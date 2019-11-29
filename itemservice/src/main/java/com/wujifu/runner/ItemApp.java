package com.wujifu.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//申明这是一个Spring Boot项目
@EnableEurekaClient
@ComponentScan(basePackages = {"com.wujifu.controller","com.wujifu.service"})//手动指定bean组件扫描范围
public class ItemApp {
    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class, args);
    }
}

