package com.ecust.touhouairline.controller;

import com.ecust.touhouairline.service.LoginService;
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
    public void TestLogin(){
        System.out.println(loginService.Login("test","123456",true));
    }
}
