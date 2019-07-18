package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserApplication {
    /*
        用户服务提供者:
            去掉 Single instance only,可以启动多次
            更改端口号为: 8001,8002,8003,启动三次
     */
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }

}
