package com.ecust.touhouairline.controller;


import com.ecust.touhouairline.service.CreateBoardingPassService;
import com.ecust.touhouairline.utils.ResultWithSingleMessage;
import com.ecust.touhouairline.utils.SingleMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreateBoardingPassContorller {
    @Autowired
    CreateBoardingPassService  createBoardingPassService;

    @PostMapping(value = "getFlight")
    public ModelMap getFlight(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String flightNo = (String)params.get("flightNo");
        SingleMessageResult result = createBoardingPassService.getFlight(flightNo);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "getBoardingPassInfo")
    public ModelMap getBoardingPassInfo(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String flightNo = (String)params.get("flightNo");
        String certificateType = (String)params.get("certificateType");
        String certificateNo = (String)params.get("certificateNo");
        ResultWithSingleMessage result = createBoardingPassService.getBoardingPassInfo(flightNo,certificateType,certificateNo);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "printBoardingPass")
    public ModelMap printBoardingPass(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        Integer detailNo = new Integer((String)params.get("detailNo"));
        SingleMessageResult result = createBoardingPassService.printBoardingPass(detailNo);
        map.put("result",result);
        return map;
    }
}
