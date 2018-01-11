package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.feign.FeignClient2;
import com.itmuch.cloud.microservicesimpleconsumermovie.feign.UserFeignClient;
import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制主体
 */
@RestController
public class MoviceController {
    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private FeignClient2 feignClient2;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfoByServiceName(@PathVariable String serviceName) {
        return this.feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}
