package com.ecust.touhouairline.controllers;

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
    @RequestMapping(value="test",method = RequestMethod.GET)
    public ModelMap showCharacter(String id){
        System.out.println("114514");
        ModelMap map = new ModelMap();
        if(id.equals("12345")){
            map.put("result","success");
            System.out.println("24岁");
        }
        return map;
    }

}