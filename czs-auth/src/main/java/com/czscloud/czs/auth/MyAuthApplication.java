package com.czscloud.czs.auth;

import com.czscloud.czs.common.feign.annotation.EnableCzsFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 认证授权中心
 */
@EnableCzsFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MyAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAuthApplication.class, args);
	}

}
