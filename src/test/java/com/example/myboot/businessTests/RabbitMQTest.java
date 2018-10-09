package com.example.myboot.businessTests;

import com.example.myboot.domain.User;
import com.example.myboot.rabbitMQ.HelloSender;
import com.example.myboot.rabbitMQ.HelloSender2;
import com.example.myboot.rabbitMQ.exchange.Sender;
import com.example.myboot.rabbitMQ.exchange.Sender2;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by BYRON.Y.Y at 2018/10/9 19:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    HelloSender helloSender;

    @Autowired
    HelloSender2 helloSender2;

    @Autowired
    Sender sender;

    @Autowired
    Sender2 sender2;

    /**
     * 多个发送者、多个消费者
      */
    @Test
    @Ignore
    public void test(){
        for(int i=1 ; i <= 10; i++){
            // 发送消息到 队列 myQueue 中； 前提是 myQueue 已经存在了。
            helloSender.send(i + "");
            helloSender2.send(i + "");
        }

        // 发送对象
        helloSender.send(User.builder()
                .nickName("RabbitMQ测试发送对象")
                .build());
    }

    @Test
    public void test2(){
        sender.send("sender1");
        sender2.send("sender2");
    }
}
