package com.ecust.touhouairline.controller;

import com.ecust.touhouairline.TouhouairlineApplicationTests;
import com.ecust.touhouairline.entity.UserEntityTmp;
import com.ecust.touhouairline.service.LoginService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController{
    @Autowired
    LoginService loginService;

    @Test
    public void registerTest1(){
        UserEntityTmp userEntityTmp = new UserEntityTmp("ysxb","114514","11451419","redtea@ecust.edu.cn","1919810","野兽先辈");
        System.out.println(loginService.register(userEntityTmp));
    }

    @Test
    public void registerTest2(){
        UserEntityTmp userEntityTmp = new UserEntityTmp("ysxb","114514","114514","redtea@ecust.edu.cn","1919810","野兽先辈");
        System.out.println(loginService.register(userEntityTmp));
    }

    @Test
    public void registerTest3(){
        UserEntityTmp userEntityTmp = new UserEntityTmp("ysxb","114514","114514","redtea@ecust.edu.cn","1919810","野兽先辈");
        System.out.println(loginService.register(userEntityTmp));
    }
}
