package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.repository.FlightRepository;
import com.ecust.touhouairline.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author 姚迟亮
 * 创建日期：2019-6-19
 **/
@Service
public class QueryFlightService {
    @Autowired
    private FlightRepository flightRepository;
    public Result<Collection<FlightEntity>> queryOneWayTicket(){
        return null;
    }
}
