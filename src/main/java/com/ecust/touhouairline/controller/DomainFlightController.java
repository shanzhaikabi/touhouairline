package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.service.DomainFlightInfoService;
import com.ecust.touhouairline.utils.SingleMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DomainFlightController {
    @Autowired
    DomainFlightInfoService domainFlightInfoService;

    @PostMapping(value = "add_flight")
    public ModelMap addFlight(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        FlightEntity flight = JSON.parseObject(JSON.toJSONString(params),FlightEntity.class);
        SingleMessageResult result = domainFlightInfoService.addFlight(flight);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "change_flight")
    public ModelMap changeFlight(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        FlightEntity flight = JSON.parseObject(JSON.toJSONString(params),FlightEntity.class);
        SingleMessageResult result = domainFlightInfoService.changeFlight(flight);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "delete_flight")
    public ModelMap deleteFlight(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String flightNo = JSON.toJSONString(params.get("flightNo"));
        SingleMessageResult result = domainFlightInfoService.deleteFlight(flightNo);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "change_flight_state")
    public ModelMap changeFlightState(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String flightNo = JSON.toJSONString(params.get("flightNo"));
        SingleMessageResult result = domainFlightInfoService.changeFlightState(flightNo,JSON.toJSONString(params.get("state")));
        map.put("result",result);
        return map;
    }
}
