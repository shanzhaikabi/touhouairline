package com.ecust.touhouairline.service;

import com.ecust.touhouairline.consts.DomainFlightInfoConsts;
import com.ecust.touhouairline.consts.OrderDetailConsts;
import com.ecust.touhouairline.entity.OrderDetailEntity;
import com.ecust.touhouairline.utils.SingleMessageResult;
import com.ecust.touhouairline.consts.FlightConsts;
import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.repository.FlightRepository;
import com.ecust.touhouairline.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 姚迟亮
 * 创建日期：2019-6-19
 **/
@Service
public class CreateBoardingPassService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    private SingleMessageResult checkFlightStatus(FlightEntity flight){
        if(flight == null) {
            return new SingleMessageResult(false ,DomainFlightInfoConsts.FLIGHT_NOT_EXISTS_ERROR);
        }
        if(!flight.getFlightState().equals(FlightConsts.CHECK_IN)){
            return new SingleMessageResult(false ,DomainFlightInfoConsts.FLIGHT_NOT_CHECK_IN_ERROR);
        }
        return new SingleMessageResult(true ,flight.getFlightNo());
    }

    public SingleMessageResult getFlight(String flightNo){
        FlightEntity flight = flightRepository.findByFlightNo(flightNo);
        return checkFlightStatus(flight);
    }

    public SingleMessageResult checkPassengerInfo(String flightNo, String  certificateType, String certificateNo){
        FlightEntity flight = flightRepository.findByFlightNo(flightNo);
        Integer detailNo = new Integer(-1);

        SingleMessageResult flightStatus = checkFlightStatus(flight);
        if(!flightStatus.isSuccess()){
            return flightStatus;
        }

        if(certificateType.equals(OrderDetailConsts.IDEBTITY)){
            detailNo = orderDetailRepository.findByIdentity(flightNo,certificateNo);
        } else
            if(certificateType.equals(OrderDetailConsts.PASSPROT)){
            detailNo = orderDetailRepository.findByPassport(flightNo,certificateNo);
        } else {
                return new SingleMessageResult(false, OrderDetailConsts.CRTTIFICATETYPE_ERROR);
            }

        if(detailNo == null) {
            return new SingleMessageResult(false, OrderDetailConsts.FLIGHT_NOT_EXISTS_ERROR);
        }

        OrderDetailEntity orderDetailEntity = orderDetailRepository.findByDetailNo(detailNo);
        if(orderDetailEntity.getState().equals(OrderDetailConsts.BOARDING_PASS_EXSIT)){
            return new SingleMessageResult(false, OrderDetailConsts.BOARDING_PASS_EXSIT);
        }

        Integer seat = orderDetailRepository.countAllByFlightno(flightNo);
        orderDetailEntity.setSeat(++seat);
        orderDetailEntity.setState(OrderDetailConsts.BOARDING_PASS_EXSIT);
        orderDetailRepository.save(orderDetailEntity);
        return new SingleMessageResult(true ,detailNo.toString());
    }
}
