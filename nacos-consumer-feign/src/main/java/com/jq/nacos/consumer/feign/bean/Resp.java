package com.jq.nacos.consumer.feign.bean;

import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * @Author: jq
 * @Date: 2019/3/14 18:12
 */
public class Resp implements Serializable {
    private int code = 0;

    private String msg = "success";

    private Object data = null;

    public static Resp success() {
        return new Resp();
    }

    public static Resp success(Object data) {
        Resp resp = new Resp();
        resp.data = data;
        return resp;
    }

    public static Resp fail(int code, String msg) {
        Resp resp = new Resp();
        resp.data = null;
        resp.code = code;
        resp.msg = msg;
        return resp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
