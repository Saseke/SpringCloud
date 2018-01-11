package com.itmuch.cloud.microservicesimpleconsumermovie.feign;

import com.itmuch.cloud.microservicesimpleconsumermovie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 控制主体
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {     //使用feign的两个坑
    @GetMapping("/simple/{id}")       //之前的版本GetMapping不支持
    public User findById(@PathVariable("id") Long id);  //pathVariable 必须加参数，否则会报错

    @PostMapping("/user")
    public User postUser(@RequestBody User user);

    //    该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以post方式进行发送请求,如果想传多个参数，用RequestPartam来写
    @GetMapping("/get-user")
    public User getUser(User user);
}
