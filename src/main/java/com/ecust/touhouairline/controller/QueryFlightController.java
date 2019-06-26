package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.OrderMasterEntity;
import com.ecust.touhouairline.service.QueryFlightService;
import com.ecust.touhouairline.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Map;

@RestController
public class QueryFlightController {
    @Autowired
    QueryFlightService queryFlightService;

    /**
     * need departTime:Timestamp
     *      departPlace:String
     *      destination:String
     *      passengerNum:Integer
     * @return Collection<FlightEntity> : 出发当天的航班列表
     */
    @PostMapping(value = "query_one_way_ticket")
    public ModelMap queryOneWayTicket(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        Timestamp departTime = (Timestamp) params.get("departTime");
        String departPlace = (String) params.get("departPlace");
        String destination = (String) params.get("destination");
        Integer passengerNum = (Integer) params.get("passengerNum");
        Result result = queryFlightService.queryOneWayTicket(departTime,departPlace,destination,passengerNum);
        map.put("result",result);
        return map;
    }

    /**
     * needs flightNo:String
     * @return Map<String,Integer> : 三种舱位的位置数量
     */
    @PostMapping(value = "show_detail_by_flight")
    public ModelMap showDetailByFlight(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        Result result = queryFlightService.showDetailByFlight((String)params.get("flightNo"));
        map.put("result",result);
        return map;
    }
}
