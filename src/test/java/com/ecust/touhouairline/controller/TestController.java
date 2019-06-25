package com.ecust.touhouairline.controller;

import com.ecust.touhouairline.consts.OrderDetailConsts;
import com.ecust.touhouairline.consts.OrderMasterConsts;
import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.entity.OrderDetailEntity;
import com.ecust.touhouairline.entity.OrderMasterEntity;
import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.repository.FlightRepository;
import com.ecust.touhouairline.repository.UserRepository;
import com.ecust.touhouairline.service.DomainOrderService;
import com.ecust.touhouairline.service.QueryFlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController{
    @Autowired
    private QueryFlightService queryFlightService;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private DomainOrderService domainOrderService;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void queryFlightTest(){
        FlightEntity flightEntity = flightRepository.findAll().get(0);
        queryFlightService.showDetailByFlight(flightEntity);
    }
    @Test
    public void createOrderTest(){
        OrderMasterEntity orderMaster = new OrderMasterEntity();
        FlightEntity flightEntity = flightRepository.findAll().get(0);
        UserEntity user = userRepository.findByUserNameAndPassword("test","123456");
        orderMaster.setUserByUserNo(user);
        orderMaster.setUserNo("test");
        orderMaster.setFlightByFlightNo(flightEntity);
        orderMaster.setTicketClass(OrderMasterConsts.ECONOMY_CLASS);
        orderMaster.setUsedCredit(0);
        OrderDetailEntity orderDetail = new OrderDetailEntity();
        orderDetail.setIdentity("31011119999999111X");
        orderDetail.setPassengerType(OrderDetailConsts.ADULT);
        orderDetail.setPassengerName("李霄");
        orderDetail.setPhone("13313331333");
        domainOrderService.createOrder(orderMaster, Arrays.asList(orderDetail));
    }
}
