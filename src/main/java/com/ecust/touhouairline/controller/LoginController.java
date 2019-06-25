package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.UserEntityTmp;
import com.ecust.touhouairline.service.LoginService;
import com.ecust.touhouairline.utils.SingleMessageResult;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelMap login(String username, String password){
        loginService.Login(username,password,true);
        return null;
    }

    @PostMapping(value = "register")
    public ModelMap register(@RequestBody String params){
        ModelMap map = new ModelMap();
        UserEntityTmp userEntityTmp = JSON.parseObject(params,UserEntityTmp.class);
        SingleMessageResult result = loginService.register(userEntityTmp);
        map.put("result",result);
        return map;
    }
}
