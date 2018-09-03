package com.sws.hdmshull.controller;

import com.sws.hdmshull.exception.LoginException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By 夜羽 on 2018/7/21
 * 全局异常处理，去找寻的Url，如果采用vue 如何接受是个问题。
 */
@ControllerAdvice
public class ExceptionHanderController {
    //打印日志
  public static final   Logger logger = LoggerFactory.getLogger(ExceptionHanderController.class);
    //出这个异常，则会被这个方法拦截
    @ExceptionHandler({Exception.class})
   // @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public String exceptionHander(HttpServletRequest request, Exception e, Model model){
        System.out.println(e.getMessage());
        model.addAttribute("url",request.getRequestURL());
        if (e instanceof LoginException){
            model.addAttribute("xxx","异常");
        }
        if(e instanceof ArithmeticException){
            model.addAttribute("msg","为0异常");
            return "/error/500";
        }
        if(e instanceof NotFound){
            return "/error/404";
        }
        //还可以处理其他类型的异常,
        return "/error";
    }
}
