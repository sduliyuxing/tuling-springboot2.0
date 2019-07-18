package com.biege.service;

import com.biege.bean.User;
import com.biege.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        logger.debug("param id : {}", id);
        User u = this.userMapper.findById(id);
        logger.debug("result name : {}", u.getName());
        return u;
    }
}
