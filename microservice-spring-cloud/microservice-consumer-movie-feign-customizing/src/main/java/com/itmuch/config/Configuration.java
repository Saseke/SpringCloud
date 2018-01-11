package com.itmuch.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * feign为fUserFeignClient进行配置使用feign的默认注解
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Contract feignContract() {
//        配置feign的契约，默认使用springMVC的契约
        return new feign.Contract.Default();
    }
//    配置feign的日志级别，如果不配置，默认没有日志删除
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
