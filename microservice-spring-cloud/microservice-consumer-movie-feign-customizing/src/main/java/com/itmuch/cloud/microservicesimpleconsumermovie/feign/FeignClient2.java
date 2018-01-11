package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

import com.itmuch.config.Configuration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 控制主体
 */
@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface FeignClient2 {
    @GetMapping("/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
