package com.ecust.touhouairline.controller;


import com.ecust.touhouairline.service.CreateBoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBoardingPassContorller {
    @Autowired
    CreateBoardingPassService  createBoardingPassService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ModelMap login(String username, String password){
        return null;
    }
}
