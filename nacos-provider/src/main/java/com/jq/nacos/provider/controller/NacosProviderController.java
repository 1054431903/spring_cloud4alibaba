package com.jq.nacos.provider.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jq
 * @Date: 2019/3/12 18:40
 */
@RestController
@RequestMapping("/test")
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/{message}")
    public String test(@PathVariable("message")String msg) {

        String str = String.format("hello Spring Cloud Alibaba - Nacos \n msg = %s \n port = %s", msg, port);
        return JSON.toJSONString(str);
    }
}
