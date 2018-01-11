package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 控制主体
 */
@RestController
public class MoviceController {
    private final RestTemplate restTemplate;

    @Autowired
    public MoviceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
    }
}
