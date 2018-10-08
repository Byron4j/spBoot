package com.example.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.myboot.mapper") // 开启mapper扫描包路径
public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}
}
