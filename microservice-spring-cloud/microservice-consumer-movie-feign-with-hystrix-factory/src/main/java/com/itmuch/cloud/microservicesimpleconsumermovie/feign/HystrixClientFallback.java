package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.stereotype.Component;

/**
 * 控制主体
 */
@Component
public class HystrixClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}