package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 控制主体
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);


    @Override
    public UserFeignClient create(Throwable throwable) {
        LOGGER.info("fallback;reason was : {}", throwable.getMessage());
        return new UserFeignClientWithFactory() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
