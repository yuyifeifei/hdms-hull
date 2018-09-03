package com.sws.hdmshull.pojo;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Date;

/**
 *   //可以在此处直接用ResultEnum
 */
public class APIResponse {
    //可以在此处直接用ResultEnum
    //状态码
    private Integer code;
    //消息
    private String message;
    //额外的内容
    private Object data;

    public APIResponse(ResultEnum resultEnum,Object data){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
        this.data = data;
    }

    public APIResponse(ResultEnum resultEnum,String message,Object data){
        this.code = resultEnum.getCode();
        this.message = message;
        this.data = data;
    }
    public APIResponse(ResultEnum resultEnum,String message){
        this.code = resultEnum.getCode();
        this.message = message;
        this.data = null;
    }
    public APIResponse(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
        this.data = null;
    }

    public static APIResponse ok(Object data){
        return new APIResponse(ResultEnum.SUCCESS,data);
    }
    public static APIResponse ok(){
        return new APIResponse(ResultEnum.SUCCESS,null);
    }
    public static APIResponse isNotOk(Object data){
        return new APIResponse(ResultEnum.FAIL, data);
    }
    public static APIResponse isNotOk(){
        return new APIResponse(ResultEnum.FAIL, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
