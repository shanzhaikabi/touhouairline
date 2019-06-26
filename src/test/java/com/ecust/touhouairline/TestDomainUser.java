package com.ecust.touhouairline;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.controller.CreateBoardingPassContorller;
import com.ecust.touhouairline.controller.DomainUserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDomainUser {

    @Autowired
    CreateBoardingPassContorller createBoardingPassContorller;

    @Test
    public void testAddPassenger(){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("flightNo","1");
        params.put("certificateType","identity");
        params.put("certificateNo","31011119999999111X");
        System.out.println(JSON.toJSONString(createBoardingPassContorller.getFlight(params)));
        System.out.println(JSON.toJSONString(createBoardingPassContorller.getBoardingPassInfo(params)));
        System.out.println(JSON.toJSONString(createBoardingPassContorller.printBoardingPass(params)));
    }


    @Test
    public void testChangePassenger(){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("userName","test");
        params.put("passenger","{" +
                "\"passengerNo\":\"3\","+
                "\"userNo\":\"123456\","+
                "\"passengerName\":\"田所浩二\","+
                "\"passengerType\":\"先辈\","+
                "\"passport\":\"\","+
                "\"identity\":\"1145141919\","+
                "\"sex\":\"野兽\","+
                "\"passengerPhone\":\"1145141919810\""+
                "}");
        System.out.println(JSON.toJSONString(domainUserController.changePassenger(params)));
    }

    @Test
    public void testRemovePassenger(){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("userName","test");
        params.put("passengerNo","4");
        System.out.println(JSON.toJSONString(domainUserController.removePassenger(params)));
    }
}
