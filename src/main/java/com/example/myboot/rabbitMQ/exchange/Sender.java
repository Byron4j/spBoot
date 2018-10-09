package com.example.myboot.rabbitMQ.exchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created by BYRON.Y.Y at 2018/10/9 21:35
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String context = this.getClass().getName() + "--" + new Date() + "--" + msg;

        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);

    }

}
