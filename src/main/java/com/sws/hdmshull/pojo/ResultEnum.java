package com.sws.hdmshull.pojo;

public enum ResultEnum {
    SUCCESS(200,"ok"),//成功
    FAIL(400,"fail"),//失败
    UNAUTHORIZED(401,"未认证"),//未认证（签名错误）
    NOT_FOUND(404,"not Found"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"系统错误"),
    ERROR(-1,"未知错误");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
