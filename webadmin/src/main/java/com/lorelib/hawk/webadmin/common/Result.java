package com.lorelib.hawk.webadmin.common;

import com.lorelib.hawk.infrastructure.stereotype.DTO;

/**
 * @author listening
 * @description Result:
 * @create 2017 04 14 14:39.
 */
public class Result implements DTO {
    /**
     * 响应码
     */
    private int code;

    /**
     * 错误信息
     */
    private String errmsg;

    public Result(int code, String errmsg) {
        this.code = code;
        this.errmsg = errmsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
