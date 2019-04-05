package com.jq.nacos.consumer.feign.service.fallback;

import com.alibaba.fastjson.JSON;
import com.jq.nacos.consumer.feign.bean.Resp;
import com.jq.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

/**
 * @Author: jq
 * @Date: 2019/3/14 18:11
 */
@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String msg) {

        return JSON.toJSONString(Resp.fail(-1, "熔断"));

    }
}
