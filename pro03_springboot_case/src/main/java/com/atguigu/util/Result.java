package com.atguigu.util;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean status;
    private String msg;
    private Object data;
    public static Result ok(Object data){
        Result result = new Result();
        result.setData(data);
        result.setStatus(true);
        result.setMsg("成功！！！");
        return result;
    }

    public Result() {
    }

    public Result(boolean status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
