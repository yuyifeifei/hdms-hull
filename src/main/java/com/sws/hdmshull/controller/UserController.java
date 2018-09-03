package com.sws.hdmshull.controller;

import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.ResultEnum;
import com.sws.hdmshull.pojo.SwsUserEntity;
import com.sws.hdmshull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;


/**
 *异常处理在controller层进行全局处理，前端参数校对的异常，在controller层处理，不需要抛出异常全局，也可以抛出去。结果集封装最好在服务层。
 * 服务层抛出自定义异常，全局处理，controller层不要catch
 */
@RequestMapping("/api/user")
@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public APIResponse registerUserInfo(@Valid SwsUserEntity user, BindingResult bindingResult) {
        //todo
        if (bindingResult.hasErrors()) {
            return new APIResponse(ResultEnum.FAIL, "用户名或者密码位数错误！");
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        APIResponse restResult = userService.insertRegister(user);
        return restResult;
}

    //check数据，根据type进行：type =1 检查用户名，type =2 检查工号，type = 3检查邮箱
    @RequestMapping("/checkdata/{type}/{data}")
    public APIResponse checkdata(@PathVariable(value = "type", required = true) Integer type, @PathVariable(value = "data", required = true) String data) {
        if (null != type && 1 == type) {
            return userService.findUserByUsername(data);
        } else if (null != type && 2 == type) {
            return userService.findUserByWorkNumberCard(data);
        } else if (null != type && 3 == type) {
            //todo 处理邮箱
            return null;
        } else {
            return new APIResponse(ResultEnum.INTERNAL_SERVER_ERROR, "检查类型type不存在");
        }
    }


    //登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //对象不用@requestparm,接受普通属性可以用@RequstPram
    public APIResponse loginUser(SwsUserEntity userEntity, HttpServletRequest request) {
        //前端进行非空校验，此处不做判断
        userEntity.setPassword(DigestUtils.md5DigestAsHex(userEntity.getPassword().getBytes()));
        APIResponse response = userService.doLogin(userEntity, request);
        return response;
    }

    /**
     * 为参数验证添加异常处理器
     * 局部异常处理
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public APIResponse handleConstraintViolationException(ConstraintViolationException cve) {
        //这里简化处理了，cve.getConstraintViolations 会得到所有错误信息的迭代，可以酌情处理
        String errorMessage = cve.getConstraintViolations().iterator().next().getMessage();
        return new APIResponse(ResultEnum.FAIL, errorMessage);
    }

    /**
     * 主键/唯一约束违反异常
     * 局部异常
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public APIResponse handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        //如果注册两个相同的用户名到报这个异常
        return new APIResponse(ResultEnum.FAIL, "违反主键/唯一约束条件");
    }
    //供mock测试用
    @RequestMapping("/hello")
    public String showIndex(){
        return "hello,mock";
    }
}
