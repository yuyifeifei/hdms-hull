/*
package com.sws.hdmshull.pojo;

*/
/**
 * 统一封装API返回信息
 * 千万别加@Entity 否则Hibernate会给你创建表
 * Created by bekey on 2017/12/10.
 *//*

public class RestResult<T> {
    //状态码
    private ResultCode code;
    //消息
    private String message;
    //额外的内容
    private Object data;

    public RestResult(){

    }

    public  RestResult(Object data){
       this.data = data;
    }

    public RestResult(ResultCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResult(ResultCode code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
*/
