package com.ecust.touhouairline.controller;

import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.repository.FlightRepository;
import com.ecust.touhouairline.service.CreateBoardingPassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController{
    @Autowired
    private CreateBoardingPassService createBoardingPassService;
    @Autowired
    private FlightRepository flightRepository;
    @Test
    public void CreateBoardingPassServiceTest(){
        System.out.println(createBoardingPassService.checkPassengerInfo("1", "护照", "EA4444444").getMessage());
    }
}
