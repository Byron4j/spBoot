package com.example.myboot.businessTests;

import com.example.myboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by BYRON.Y.Y at 2018/10/8 19:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test(){
        System.out.println("基于mybatis注解方式查询User：" + userMapper.getAll());
    }
}
