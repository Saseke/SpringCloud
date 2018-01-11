package com.itmuch.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
