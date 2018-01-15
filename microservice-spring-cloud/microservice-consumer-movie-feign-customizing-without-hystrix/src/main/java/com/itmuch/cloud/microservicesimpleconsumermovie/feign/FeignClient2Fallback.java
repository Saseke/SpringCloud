package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

/**
 * 控制主体
 */
public class FeignClient2Fallback implements FeignClient2 {
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "haha";
    }
}
