package com.sws.hdmshull.exception;

import com.sws.hdmshull.pojo.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created By 夜羽 on 2018/7/21
 *   可以在此处直接用ResultEnum
 *   自定义异常必须继承之RuntimeException,因为只有这个异常出现了，spring框架才会进行事务回滚。
 */
//@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class LoginException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    private Integer code;

    //一系列构造方法
    public LoginException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
