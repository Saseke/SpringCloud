package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 控制主体
 */
@RestController
public class MoviceController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    //MicroserviceSimpleConsumerMovieApplication
    @Autowired
    public MoviceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
//        VIP Virtual IP
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return "1";
    }
}
