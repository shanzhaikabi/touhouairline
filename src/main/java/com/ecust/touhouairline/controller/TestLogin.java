package com.ecust.touhouairline.controller;

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
        ModelMap map = new ModelMap();
        System.out.println("114514");
        if(id.equals("12345")){
            map.put("result",demoService.getDemoById(Integer.valueOf(id)));
            System.out.println(demoService.getDemoById(Integer.valueOf(id)).getName());
        }
        return map;
    }

}