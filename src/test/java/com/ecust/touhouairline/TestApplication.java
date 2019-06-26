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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    CreateBoardingPassContorller createBoardingPassContorller;

    @Test
    public void contextLoads(){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("flightNo","1");
        params.put("certificateType","identity");
        params.put("certificateNo","31011119999999111X");
        System.out.println(JSON.toJSONString(createBoardingPassContorller.getFlight(params)));
        System.out.println(JSON.toJSONString(createBoardingPassContorller.getBoardingPassInfo(params)));
        System.out.println(JSON.toJSONString(createBoardingPassContorller.printBoardingPass(params)));
    }
}
