package com.biege.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: Receiver </p>
 * <p>Description:  </p>
 * <p>Company: http://www.biege.com/ </p>
 * <p>Author: 别圣平 </p>
 * <p>CreateTime: 2019-06-24 07:32 </p>
 * <p>Version: 1.0 </p>
 */
@Component
@RabbitListener(queues = {"first"})
public class Receiver {
    // 消息接受者
    @RabbitHandler
    public void process(String msg) {
        System.out.println("receive msg : " + msg);
    }

}
