package com.biege.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 在测试类RabbitmqTest中测试
    public void send() {
        rabbitTemplate.convertAndSend("first", "别哥,帅!");
    }

}