package com.itmuch.cloud.microservicesimpleprovideruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.itmuch.cloud.microservicesimpleprovideruser.dao")
public class MicroserviceSimpleProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
    }
}
