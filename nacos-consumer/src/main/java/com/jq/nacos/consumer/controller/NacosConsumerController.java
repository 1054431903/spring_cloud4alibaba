package com.jq.nacos.consumer.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jq
 * @Date: 2019/3/12 20:07
 */
@RestController
@RequestMapping("/test")
public class NacosConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/app")
    public String echo() {
        ServiceInstance instance = loadBalancerClient.choose("nacos-provider");

        String url = String.format("http://%s:%s/test/%s", instance.getHost(), instance.getPort(),appName);
        return restTemplate.getForObject(url, String.class);
    }
}
