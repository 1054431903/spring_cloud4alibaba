package com.jq.nacos.consumer.feign.service;

import com.jq.nacos.consumer.feign.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jq
 * @Date: 2019/3/13 14:27
 */
@FeignClient(value = "nacos-provider",fallback = EchoServiceFallback.class)
public interface EchoService {
    @RequestMapping("/test/{msg}")
    String echo(@PathVariable("msg") String msg);
}
