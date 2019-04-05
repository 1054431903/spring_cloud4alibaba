package com.jq.nacos.consumer.feign.controller;

import com.jq.nacos.consumer.feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jq
 * @Date: 2019/3/13 14:29
 */
@RestController
@RefreshScope
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private EchoService echoService;


    @Value("${ceshi.name}")
    private String name;

    @Value("${ceshi.age}")
    private int age;

    @RequestMapping("/user")
    public String test() {
        return "user:" + name + "\n" + "age:" + age;
    }

//    @GetMapping("/hi")
//    public String echo() {
//        return echoService.echo(name);
//    }
}
