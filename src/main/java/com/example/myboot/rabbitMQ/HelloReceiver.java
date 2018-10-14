package com.example.myboot.rabbitMQ;

import com.example.myboot.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created by BYRON.Y.Y at 2018/10/9 20:15
 */
@Component
@RabbitListener(queues = "myQueue")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println(this.getClass().getName() + "----RabbitMQ接收到的消息: " + hello);
    }

    /**
     * RabbitMQ支持传入对象
     * @param user
     */
    @RabbitHandler
    public void process(User user) {
        System.out.println(this.getClass().getName() + "----RabbitMQ接收到的消息是User对象: " + user);
    }

}
