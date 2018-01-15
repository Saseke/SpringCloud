package com.itmuch.config;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 为FeignClient2j进行注解的配置，使用springmvc的注解
 */
@Configuration
public class Configuration2 {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        配置SpringSecurity 的权限认证
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
