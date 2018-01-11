package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.feign.UserFeignClient;
import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制主体
 */
@RestController
public class MoviceController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return this.userFeignClient.postUser(user);
    }

    @GetMapping("/get-user")
    public User getUser(User user) {
        return this.userFeignClient.getUser(user);
    }
}
