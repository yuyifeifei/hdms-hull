package com.sws.hdmshull.service;

import com.sws.hdmshull.exception.LoginException;
import com.sws.hdmshull.pojo.*;
import com.sws.hdmshull.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public APIResponse insertRegister(@Valid SwsUserEntity user) {
        Object userSaved = userRepository.save(user);
        if (null != userSaved){
            return new APIResponse(ResultEnum.SUCCESS,"注册成功",userSaved);
        }
        //释放全局异常
        throw new LoginException(ResultEnum.FAIL);
    }

    @Override
    public APIResponse findUserByUsername(String username) {
        SwsUserEntity user = userRepository.findByUsername(username);
        if (null == user){
            return  new APIResponse(ResultEnum.SUCCESS,"用户名可用",true);
        }
        return new APIResponse(ResultEnum.FAIL,"用户名已经存在",false);
    }

    @Override
    public APIResponse findUserByWorkNumberCard(String workNumerCard) {
        SwsUserEntity user = userRepository.findByWorkNumberCard(workNumerCard);
        if (null == user){
            return  new APIResponse(ResultEnum.SUCCESS,"用户名可用",true);
        }
        return new APIResponse(ResultEnum.FAIL,"用户名已经存在",false);
    }

    @Override
    public APIResponse doLogin(SwsUserEntity userEntity, HttpServletRequest request) {
        //如果使用缓存，就先从缓存中查询，然后没有执行数据库查询，登陆成功时候，需要将用户放入session中和缓存中。
        //如果使用的注解缓存，那么就只需要加入注解，对代码没有太多需要修改的。
        //用工号登陆
        SwsUserEntity user = userRepository.findByWorkNumberCard(userEntity.getWorkNumberCard());
        if (null == user) {
            return new APIResponse(ResultEnum.FAIL, "用户名不存在");
        } else if (user.getPassword() != null && !user.getPassword().equals(userEntity.getPassword())) {
            return new APIResponse(ResultEnum.FAIL, "密码错误！");
        } else {
            //登陆成功，放入session中
            request.getSession().setAttribute("user",user);
            return new APIResponse(ResultEnum.SUCCESS, "登陆成功", user);
            }
    }
}
