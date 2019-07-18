package com.example.user.controller;

import com.example.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallback",
            groupKey = "orderUserGroup",
            threadPoolKey = "orderUserIdThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1")})
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        log.info("================请求用户中心接口，用户id:" + id + "==============");
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }








    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

}
