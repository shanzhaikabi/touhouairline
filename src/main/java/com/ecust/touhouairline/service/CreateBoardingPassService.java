package com.ecust.touhouairline.service;

import com.ecust.touhouairline.consts.DomainFlightInfoConsts;
import com.ecust.touhouairline.consts.OrderDetailConsts;
import com.ecust.touhouairline.entity.LuggageEntity;
import com.ecust.touhouairline.entity.OrderDetailEntity;
import com.ecust.touhouairline.utils.ResultWithSingleMessage;
import com.ecust.touhouairline.utils.SingleMessageResult;
import com.ecust.touhouairline.consts.FlightConsts;
import com.ecust.touhouairline.consts.LuggageConsts;
import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.repository.FlightRepository;
import com.ecust.touhouairline.repository.LuggageRepository;
import com.ecust.touhouairline.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private LuggageRepository luggageRepository;

    private SingleMessageResult checkFlightStatus(FlightEntity flight){
        if(flight == null) {
            return new SingleMessageResult(false ,DomainFlightInfoConsts.FLIGHT_NOT_EXISTS_ERROR);
        }
        if(!flight.getFlightState().equals(FlightConsts.CHECK_IN)){
            return new SingleMessageResult(false ,DomainFlightInfoConsts.FLIGHT_NOT_CHECK_IN_ERROR);
        }
        return new SingleMessageResult(true ,DomainFlightInfoConsts.FLIGHT_GET_SUCCESS);
    }

    public SingleMessageResult getFlight(String flightNo){
        FlightEntity flight = flightRepository.findByFlightNo(flightNo);
        return checkFlightStatus(flight);
    }

    private SingleMessageResult checkPassengerInfo(String flightNo, String  certificateType, String certificateNo){
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
    public ResultWithSingleMessage<Map<String,String>> getBoardingPassInfo(String flightNo, String  certificateType, String certificateNo){
        SingleMessageResult userInfo = checkPassengerInfo(flightNo,certificateType,certificateNo);
        if(!userInfo.isSuccess()){
            return new ResultWithSingleMessage<>(false,null,userInfo.getMessage());
        }
        FlightEntity flight = flightRepository.findByFlightNo(flightNo);
        OrderDetailEntity orderDetail = orderDetailRepository.findByDetailNo(new Integer(userInfo.getMessage()));
        Map<String,String> boardingPassInfo = new HashMap<>();
        boardingPassInfo.put("detailNo",orderDetail.getDetailNo().toString());
        boardingPassInfo.put("passengerName",orderDetail.getPassengerName());
        boardingPassInfo.put("flightNo",flight.getFlightNo());
        boardingPassInfo.put("departPlace",flight.getDepartPlace());
        boardingPassInfo.put("destination",flight.getDestination());
        boardingPassInfo.put("boardingGate",flight.getBoardingGate());
        boardingPassInfo.put("departTime",flight.getDepartTime().toString());
        boardingPassInfo.put("seat",orderDetail.getSeat().toString());
        return new ResultWithSingleMessage<>(true,boardingPassInfo,null);
    }
    public SingleMessageResult printBoardingPass(Integer detailNo){
        return new SingleMessageResult(true, null);
    }

    public SingleMessageResult luggageShipping(Integer detailNo, Integer weight){
        if(orderDetailRepository.findByDetailNo(detailNo)==null) {
            return new SingleMessageResult(false, OrderDetailConsts.ORDERDEDAIL_NOT_EXISTS_ERROR);
        }
        if(weight>LuggageConsts.LUGGAGE_MAX_WEIGHT)
            return new SingleMessageResult(false, LuggageConsts.LUGGAGE_WEIGHT_EXCEED_ERROR);
        LuggageEntity luggageEntity = new LuggageEntity();
        luggageEntity.setDetailNo(detailNo);
        luggageEntity.setWeight(weight);
        Integer fee = new Integer(2*weight);
        luggageEntity.setShippingFee(fee);
        luggageRepository.save(luggageEntity);
        return new SingleMessageResult(true, LuggageConsts.LUGGAGE_SHIPPING_SUCCESS);
    }
}
