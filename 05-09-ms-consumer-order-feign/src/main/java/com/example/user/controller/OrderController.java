package com.example.user.controller;

import com.example.entity.User;
import com.example.user.feign.RefactorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private RefactorUserService refactorUserService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return refactorUserService.getUser(id);
    }
}
