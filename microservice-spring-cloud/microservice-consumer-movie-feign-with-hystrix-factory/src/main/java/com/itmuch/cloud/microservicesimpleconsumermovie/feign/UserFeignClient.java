package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 控制主体
 */
@FeignClient(name = "microservice-provider-user", /*fallback = HystrixClientFallback.class,*/ fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping("/simple/{id}")
    public User findById(@PathVariable("id") Long id);
}

