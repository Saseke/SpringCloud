package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import com.itmuch.config.Configuration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 控制主体
 */
@FeignClient(name = "microservice-provider-user", configuration = Configuration.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {     //使用feign的两个坑
    /**
     * 使用feign默认的注解格式
     *
     * @param id id
     * @return 查询得到的user
     */
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
