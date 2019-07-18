package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserApplication {

    /*
        复制自 07-01-ms-provider-user
        启动3次user微服务.端口号为  8001,8002,8003
     */
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }

}
