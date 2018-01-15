package com.itmuch.cloud.microservicesimpleconsumermovie;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置ribbon，使得ribbon不是按照默认的轮循算法进行负载均衡，config不能放在application context目录下，也包括其子目录
 */

@Configuration
@ExcludeFromComponentScan
public class TestConfigration {
    //    @Autowired
//    IClientConfig config;
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
