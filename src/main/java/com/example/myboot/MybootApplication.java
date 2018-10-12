package com.example.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.myboot.mapper") // 开启mapper扫描包路径
@EnableScheduling  // 开启支持定时任务的注解
public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}
}
