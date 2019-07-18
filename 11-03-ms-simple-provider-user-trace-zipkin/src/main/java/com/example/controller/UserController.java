package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Registration registration;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) throws Exception {
        log.info("用户中心接口：查询用户" + id + "信息");
        User findOne = userRepository.findById(id).get();
        return findOne;
    }

    @GetMapping("/getIpAndPort")
    public String findById() {
        return registration.getHost() + ":" + registration.getPort();
    }
}