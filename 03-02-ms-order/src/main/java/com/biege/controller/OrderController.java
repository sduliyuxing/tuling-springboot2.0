package com.biege.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.getUserByIdUrl}")
    private String getUserByIdUrl;

    @Value("${user.findUserByIdUrl}")
    private String findUserByIdUrl;

    // http://localhost:8082/order/user/getById?userId=1
    @RequestMapping("/user/getById")
    public Object getUserById(String userId) {
        String url = getUserByIdUrl + "?id=" + userId;
        logger.debug("param userId : {}, request url : {}", userId, url);
        Object result = restTemplate.getForEntity(url, Object.class);
        return result;
    }

    // http://localhost:8082/order/user/getById/1
    @RequestMapping("/user/findById/{userId}")
    public Object findUserById(@PathVariable("userId") String userId) {
        String url = findUserByIdUrl + "/" + userId;
        logger.debug("param userId : {}, request url : {}", userId, url);
        Object result = restTemplate.getForEntity(url, Object.class);
        return result;
    }

}