package com.czscloud.czs.gateway.config;

import com.czscloud.czs.gateway.filter.MyRequestGlobalFilter;
import com.czscloud.czs.gateway.filter.PasswordDecoderFilter;
import com.czscloud.czs.gateway.filter.ValidateCodeGatewayFilter;
import com.czscloud.czs.gateway.handler.GlobalExceptionHandler;
import com.czscloud.czs.gateway.handler.ImageCodeHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 网关配置
 *
 * @author L.cm
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(com.czscloud.czs.gateway.config.GatewayConfigProperties.class)
public class GatewayConfiguration {

	@Bean
	public PasswordDecoderFilter passwordDecoderFilter(com.czscloud.czs.gateway.config.GatewayConfigProperties configProperties) {
		return new PasswordDecoderFilter(configProperties);
	}

	@Bean
	public MyRequestGlobalFilter pigRequestGlobalFilter() {
		return new MyRequestGlobalFilter();
	}

	@Bean
	public ValidateCodeGatewayFilter validateCodeGatewayFilter(com.czscloud.czs.gateway.config.GatewayConfigProperties configProperties,
															   ObjectMapper objectMapper, RedisTemplate redisTemplate) {
		return new ValidateCodeGatewayFilter(configProperties, objectMapper, redisTemplate);
	}

	@Bean
	public GlobalExceptionHandler globalExceptionHandler(ObjectMapper objectMapper) {
		return new GlobalExceptionHandler(objectMapper);
	}

	@Bean
	public ImageCodeHandler imageCodeHandler(RedisTemplate redisTemplate) {
		return new ImageCodeHandler(redisTemplate);
	}

}
