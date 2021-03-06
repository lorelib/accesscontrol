package com.lorelib.hawk.infrastructure.helpers.base;

import com.lorelib.hawk.infrastructure.stereotype.Dto;

/**
 * @author listening
 * @description Response:
 * @create 2017 04 13 16:22.
 */
public class Response<T> implements Dto {
    /**
     * 响应码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 数据载体
     */
    private T body;

    public Response() {
    }

    public Response(int code, String errmsg) {
        this.code = code;
        this.msg = errmsg;
    }

    public Response(int code, String errmsg, T body) {
        this(code, errmsg);
        this.body = body;
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

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}