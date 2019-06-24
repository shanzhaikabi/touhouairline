package com.ecust.touhouairline.controllers;

import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin2.message.Serializer;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

@RestController
public class TestLogin {
    @RequestMapping(value="test",method = RequestMethod.GET)
    public ModelMap showCharacter(String id){
        System.out.println("114514");
        ModelMap map = new ModelMap();
        if(id!=null && id.equals("12345")) {
            map.put("result", (new TestClass(10,"1919810")));
            System.out.println("24岁，是学生");
        }
        else map.put("result", (new TestClass(110,"110")));
        return map;
    }
    @RequestMapping(value="home",method = RequestMethod.GET)
    public ModelMap testFabric(String id){
        System.out.println("114514");
        ModelMap map = new ModelMap();
        if(id!=null && id.equals("114514")) {
            map.put("result", (new TestClass(10,"1919810")));
            System.out.println("24岁，是学生");
        }
        else map.put("result", (new TestClass(110,"110")));
        return map;
    }
    class TestClass implements Serializable {
        int x;
        String y;
        TestClass(int xx, String yy){x=xx;y=yy;}

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }
    }
}