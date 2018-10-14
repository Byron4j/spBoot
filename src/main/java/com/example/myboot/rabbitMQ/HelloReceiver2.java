package com.example.myboot.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created by BYRON.Y.Y at 2018/10/9 20:15
 */
@Component
@RabbitListener(queues = "myQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println(this.getClass().getName() + "----RabbitMQ接收到的消息: " + hello);
    }

}
