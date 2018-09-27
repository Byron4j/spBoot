package com.example.myboot.businessTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void test(){
        System.out.println(redisTemplate.opsForSet().add("spredis", "something..."));
    }

}
