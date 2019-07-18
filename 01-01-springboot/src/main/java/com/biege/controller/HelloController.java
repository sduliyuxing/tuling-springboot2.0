package com.biege.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: HelloController </p>
 * <p>Description:  </p>
 * <p>Company: http://www.biege.com/ </p>
 * <p>Author: 别圣平 </p>
 * <p>CreateTime: 2019-06-23 19:17 </p>
 * <p>Version: 1.0 </p>
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World !";
    }


}