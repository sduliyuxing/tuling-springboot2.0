package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    // 必须在使用@Value注解的类上,添加注解@RefreshScope,才能实现刷新

    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String hello() {
        return profile;
    }
}
