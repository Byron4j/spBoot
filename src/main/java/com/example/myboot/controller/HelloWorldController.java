package com.example.myboot.controller;

import com.example.myboot.cfg.FefiProperties;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    FefiProperties fefiProperties;

    @RequestMapping("/")
    public String sayHello(){
        return JSONObject.fromObject(fefiProperties).toString();
    }
}
