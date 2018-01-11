package com.itmuch.cloud.microservicesimpleprovideruser.controller;

import com.itmuch.cloud.microservicesimpleprovideruser.dao.UserDao;
import com.itmuch.cloud.microservicesimpleprovideruser.obj.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制主体
 */
@RestController
public class UserController {
    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return userDao.findById(id);
    }
}
