package com.example.myboot.rabbitMQ;

import com.example.myboot.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created by BYRON.Y.Y at 2018/10/9 21:35
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String context = this.getClass().getName() + "--" + new Date() + "--" + msg;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("myQueue", context);
    }

    public void send(User user) {
        String context = this.getClass().getName() + "--" + new Date() + "--" + user;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("myQueue", context);
    }

}
