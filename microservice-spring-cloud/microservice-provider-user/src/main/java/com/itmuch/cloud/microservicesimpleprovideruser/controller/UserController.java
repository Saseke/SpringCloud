package com.itmuch.cloud.microservicesimpleprovideruser.controller;

import com.itmuch.cloud.microservicesimpleprovideruser.dao.UserDao;
import com.itmuch.cloud.microservicesimpleprovideruser.obj.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制主体
 */
@RestController
public class UserController {
    private final UserDao userDao;
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        LOGGER.info("----------------------------" + "通过这了" + "-----------------------");
        return userDao.findById(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        return this.discoveryClient.getLocalServiceInstance();
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return user;
    }

    //    该请求不会成功
    @GetMapping("/get-user")
    public User getUser(User user) {
        return user;
    }

    @GetMapping("list-all")
    public List<User> listAll() {
        ArrayList<User> list = new ArrayList<>();
        User user = new User(1L, "zhangsan");
        User user2 = new User(2L, "zhangsan");
        User user3 = new User(3L, "zhangsan");
        User user4 = new User(4L, "zhangsan");
        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return list;
    }
}
