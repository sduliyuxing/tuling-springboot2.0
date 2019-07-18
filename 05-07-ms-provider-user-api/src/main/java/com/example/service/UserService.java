package com.example.service;

import com.example.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

    @GetMapping("/user/{id}")
    User getUser(@PathVariable(value = "id") Long id);

}
