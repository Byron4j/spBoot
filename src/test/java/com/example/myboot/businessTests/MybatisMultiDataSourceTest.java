package com.example.myboot.businessTests;

import com.example.myboot.domain.User;
import com.example.myboot.mapper.UserMapper;
import com.example.myboot.mapper2.UserMapper2;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * created by BYRON.Y.Y at 2018/10/8 19:51
 * 多数据源测试用例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisMultiDataSourceTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapper2 userMapper2;
    @Test
    @Ignore
    public void test(){
        System.out.println("基于mybatis注解方式查询User：" + userMapper.getAll());
    }

    @Test
    @Ignore
    public void test2(){
        System.out.println("基于mybatis XML配置方式查询User：" + userMapper.selectByCnd(User.builder()
                .userName("aa1")
                .build()));
    }

    @Test
    @Ignore
    public void test3(){
        System.out.println("数据源2----基于mybatis注解方式查询User：" + userMapper2.getAll());
    }

    @Test
    public void test4(){
        System.out.println("数据源2----基于mybatis XML配置方式查询User：" + userMapper2.selectByCnd(User.builder()
                .userName("aa1")
                .build()));
    }
}
