package com.example.myboot.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by BYRON.Y.Y at 2018/9/29 9:11
 */
//@Entity  // 需要存在person表，且需要指定主键id
//@Document  // 需要配置mongodb
public class Person {
    @Id
    @GeneratedValue
    private Long id;
}
