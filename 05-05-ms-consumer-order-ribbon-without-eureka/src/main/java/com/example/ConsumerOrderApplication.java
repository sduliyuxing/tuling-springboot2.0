package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerOrderApplication {
    /*
        以前都是通过  eureka客户端依赖,引入Ribbon依赖,如果企业中是DUBBO-ZK架构,只是想引入Ribbon做负载均衡
        如何抛开  eureka, 操作 Ribbon
        引入 spring-cloud-starter-netflix-ribbon 依赖

        属性配置:
            microservice-provider-user:
              ribbon:
                listOfServers: localhost:8001,localhost:8002,localhost:8003
                NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
     */

    @Bean
    @LoadBalanced //ribbon的负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }

}
