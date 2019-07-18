package com.biege.controller;

import com.biege.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j  // 引入 lombok 依赖
public class HelloController {

    // private final Log logger = LoggerFactory.getLogger(HelloController.class);
    // private final Logger log = Logger.getLogger(HelloController.class);

    @Value("${teacher.name}")
    private String teacherName;

    @Value("${teacher.info}")
    private String info;

    @Autowired
    private HelloService helloService;

    @RequestMapping("/testHello")
    @ResponseBody
    public Object testHello(Map<String, String> map) {
        log.info(this.helloService.sayHello());
        return this.helloService.sayHello();
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        // log.debug("test {}", " -----debug test");
        // log.info("test {}", " -----info test");
        log.debug("log4j debug level");
        log.info("log4j info level");
        log.error("log4j error level");
        return "Hello World !" + this.teacherName + this.info;
    }

    // 引入spring-boot-starter-thymeleaf依赖
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(ModelMap map) {
        // 参数map类型为  ModelMap
        map.put("name", "别哥");
        //对应src/main/resources/templates/testThymeleaf.html
        return "testThymeleaf";   // 不带后缀名
    }

    // 引入spring-boot-starter-freemarker依赖
    @RequestMapping("/testFreeMarker")
    public String testFreeMarker(Map<String, String> map) {
        // 参数map类型为 Map
        map.put("name", "world!!!");
        //对应src/main/resources/templates/hello.ftl
        return "hello";  // 不带后缀名
    }

    @RequestMapping("/exception")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

}
