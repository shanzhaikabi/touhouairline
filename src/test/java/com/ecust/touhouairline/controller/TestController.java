package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.repository.FlightRepository;
import com.ecust.touhouairline.repository.UserRepository;
import com.ecust.touhouairline.service.QueryFlightService;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController{
    @Autowired
    private FlightRepository flightRepository;
    @Test
    public void Test(){
        FlightEntity test = flightRepository.findById("1").get();
        System.out.println(JSON.toJSONString(test));
    }
}
