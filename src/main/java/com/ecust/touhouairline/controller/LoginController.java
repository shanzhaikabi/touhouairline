package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.UserEntityTmp;
import com.ecust.touhouairline.service.LoginService;
import com.ecust.touhouairline.utils.SingleMessageResult;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelMap login(String username, String password){
        loginService.Login(username,password,true);
        return null;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ModelMap register(String userEntityTmpJson){
        ModelMap map = new ModelMap();
        UserEntityTmp userEntityTmp = JSON.parseObject(userEntityTmpJson,UserEntityTmp.class);
        SingleMessageResult result = loginService.register(userEntityTmp);
        map.put("success",result.isSuccess());
        map.put("message",result.getMessage());
        return map;
    }
}
