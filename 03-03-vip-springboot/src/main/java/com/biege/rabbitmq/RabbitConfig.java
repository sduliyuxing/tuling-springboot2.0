package com.biege.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: RabbitConfig </p>
 * <p>Description:  </p>
 * <p>Company: http://www.biege.com/ </p>
 * <p>Author: 别圣平 </p>
 * <p>CreateTime: 2019-06-24 07:24 </p>
 * <p>Version: 1.0 </p>
 */
@Configuration
public class RabbitConfig {
    // 配置类中注入  Queue

    // 引入 spring-boot-starter-amqp 依赖
    @Bean
    public Queue firstQueue() {
        // 创建一个队列，名称为：first
        return new Queue("first");
    }

}
