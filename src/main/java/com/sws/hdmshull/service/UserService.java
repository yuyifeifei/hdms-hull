package com.sws.hdmshull.service;

import com.sws.hdmshull.pojo.APIResponse;
import com.sws.hdmshull.pojo.SwsUserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public interface UserService {
    APIResponse insertRegister(@Valid SwsUserEntity user);

    APIResponse findUserByUsername(String username);

    APIResponse findUserByWorkNumberCard(String workNumberCard);

    APIResponse doLogin(SwsUserEntity userEntity, HttpServletRequest request);
}
