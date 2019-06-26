package com.ecust.touhouairline;

import com.alibaba.fastjson.JSON;
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
    DomainUserController domainUserController;

    @Test
    public void contextLoads(){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("userName","test");
        params.put("passenger","{" +
                "\"userNo\":\"123456\","+
                "\"passengerName\":\"田所浩二\","+
                "\"passengerType\":\"先辈\","+
                "\"passport\":\"114514\","+
                "\"identity\":\"\","+
                "\"sex\":\"野兽\","+
                "\"passengerPhone\":\"1145141919810\""+
                "}");
        System.out.println(JSON.toJSONString(domainUserController.addPassenger(params)));
    }
}
