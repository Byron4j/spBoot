package com.example.myboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/index")
    public String sayHello(){
        return "Hello,myBoot!";
    }
}
