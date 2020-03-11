package com.eb.gc.common;

/**
 * Author: gc
 * Date: 2020/3/11 14:50
 * Description: TODO
 */
public class ResultInfo {

    private String code;
    private String msg;

    public ResultInfo() {
    }

    public ResultInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultInfo success(String msg) {
        return new ResultInfo("200", msg);
    }

    public static ResultInfo fail(String msg) {
        return new ResultInfo("500", msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
