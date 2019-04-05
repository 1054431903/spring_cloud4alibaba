package com.jq.gateway.filters;

import com.alibaba.fastjson.JSON;
import com.jq.gateway.bean.Resp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @Author: jq
 * @Date: 2019/3/15 10:21
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    /**
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)) {
            ServerHttpResponse response = exchange.getResponse();

            Resp no_token = Resp.fail(401, "no token");
            byte[] bytes = JSON.toJSONBytes(no_token);
            DataBuffer wrap = response.bufferFactory().wrap(bytes);

            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type","application/json;charset=UTF-8");
            return response.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器的优先级
     * 与数字成反比
     * @return
     */
    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
