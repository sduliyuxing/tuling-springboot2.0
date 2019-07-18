package com.example;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker  // 这时需要 加这个注解
public class ConsumerOrderApplication {

    // Hystrix监控
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }

    // 运行项目后访问地址：http://项目ip:端口号/hystrix.stream，端点监控数据中心
    // Spring Boot 2.0 下 hystrix.stream 404 问题
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }


    // SpringBoot 1.5.x的监控接口是ip:port/hystrix.stream
    // SpringBoot 2.0.x的监控是ip:port/actuator/hystrix.stream

}
