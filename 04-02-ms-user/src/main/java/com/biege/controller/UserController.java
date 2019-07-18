package com.biege.controller;

import com.biege.bean.User;
import com.biege.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // http://localhost:9001/user/getById?id=2
    @RequestMapping("/getById")
    public User getUserById(String id) {
        logger.debug("param id : {}", id);
        return this.userService.findById(Integer.parseInt(id));
    }

    // http://localhost:9001/user/findById/2
    @RequestMapping("/findById/{id}")
    public User findUserById(@PathVariable("id") String id) {
        logger.debug("param id : {}", id);
        return this.userService.findById(Integer.parseInt(id));
    }

}