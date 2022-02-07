package com.czscloud.czs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MyGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyGatewayApplication.class,args);
    }
}
