package com.example.myboot.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created by BYRON.Y.Y at 2018/10/9 21:35
 */
@Component
public class HelloSender2 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String context = this.getClass().getName() + "--" + new Date() + "--" + msg;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("myQueue", context);
    }

}
