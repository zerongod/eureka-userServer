package com.example.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//必须加入@EnableEurekaClient和@EnableFeignClients注解

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

}
