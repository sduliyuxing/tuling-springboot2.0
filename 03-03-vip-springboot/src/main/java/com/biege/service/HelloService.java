package com.biege.service;

import org.springframework.stereotype.Service;

/**
 * <p>Title: HelloService </p>
 * <p>Description:  </p>
 * <p>Company: http://www.biege.com/ </p>
 * <p>Author: 别圣平 </p>
 * <p>CreateTime: 2019-06-24 06:21 </p>
 * <p>Version: 1.0 </p>
 */
@Service
public class HelloService {

    public String sayHello() {
        return "Hello world!";
    }
}
