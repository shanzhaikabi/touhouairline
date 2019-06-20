package com.ecust.touhouairline.controllers;

import com.ecust.touhouairline.entity.DemoEntity;
import com.ecust.touhouairline.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TestLogin {

    @Autowired
    DemoService demoService;

    @RequestMapping(value="test",method = RequestMethod.GET)
    public ModelMap showCharacter(String id){
        System.out.println("114514");
        ModelMap map = new ModelMap();
        if(id!=null && id.equals("12345")) {
            DemoEntity entity = demoService.getDemoEntityByNameAndPassword("123","123");
            System.out.println("24岁，是学生" + entity);
            map.put("result", entity);
        }
        return map;
    }

}