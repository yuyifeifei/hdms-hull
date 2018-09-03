package com.sws.hdmshull.controller;

import com.sws.hdmshull.exception.MessageCenterException;
import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
 
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
 
    /**
      * @Author: gmy
      * @Description: 系统异常捕获处理
      * @Date: 16:07 2018/5/30
      */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public APIResponse javaExceptionHandler(Exception ex) {//APIResponse是项目中对外统一的出口封装，可以根据自身项目的需求做相应更改
        logger.error("捕获到Exception异常",ex);
        //异常日志入库
 
        return new APIResponse(ResultEnum.FAIL,ex.getMessage(),null);
    }
 
    /**
      * @Author: gmy
      * @Description: 自定义异常捕获处理
      * @Date: 16:08 2018/5/30
      */
    @ResponseBody
    @ExceptionHandler(value = MessageCenterException.class)//MessageCenterException是自定义的一个异常
    public APIResponse messageCenterExceptionHandler(MessageCenterException ex) {
        logger.error("捕获到MessageCenterException异常",ex);
        //异常日志入库
 
        return ex.getApiResponse();
    }
 
}
