package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbineApplication {

  /*
      测试项目启动顺序:
        1. eureka
        2. 服务提供方 user服务:  07-01-ms-provider-user
        3. 待聚合项目1: 服务消费方: 06-03-ms-consumer-order-ribbon-hystrix-fallback项目 ,端口号:8010
        4. 待聚合项目2: 服务消费方: 07-04-ms-consumer-order-hystrix-stream项目,端口号: 8020
        5、运行07-06-ms-hystrix-turbine项目
        6、运行07-05-ms-hystrix-dashboard项目
   */

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }


}