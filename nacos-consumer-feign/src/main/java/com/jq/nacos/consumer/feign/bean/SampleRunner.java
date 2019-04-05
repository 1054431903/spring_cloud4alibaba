package com.jq.nacos.consumer.feign.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
class SampleRunner implements ApplicationRunner {

    @Value("${ceshi.name}")
    String userName;

    @Value("${ceshi.age}")
    int userAge;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userName);
        System.out.println(userAge);
    }
}