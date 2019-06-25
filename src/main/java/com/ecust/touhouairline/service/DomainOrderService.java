package com.ecust.touhouairline.service;

import com.ecust.touhouairline.consts.OrderMasterConsts;
import com.ecust.touhouairline.entity.OrderDetailEntity;
import com.ecust.touhouairline.entity.OrderMasterEntity;
import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.repository.OrderDetailRepository;
import com.ecust.touhouairline.repository.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;

/**
 * @author 姚迟亮
 * 创建日期：2019-6-19
 **/
@Service
public class DomainOrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    /**
     * 显示订单详情
     * @param orderMaster 订单
     * @return 订单详情的集合
     */
    public Collection<OrderDetailEntity> showOrderDetail(OrderMasterEntity orderMaster){
        return orderMaster.getOrderdetailsByOrderNo();
    }
    public void createOrder(){}

    /**
     *
     * @param orderMaster 订单实体
     * @return 订单退款金额和积分
     */
    public String deleteOrder(OrderMasterEntity orderMaster){
        orderMaster.setState(OrderMasterConsts.CANCELLED);
        //取消订单应退钱款和积分
        int returnMoney = orderMaster.getSum();
        int returnCredit = orderMaster.getUsedCredit();
        String state = orderMaster.getState();
        java.util.Date today = new java.util.Date();
        //如果是未付款订单，可以随时取消。
        if(state.equals(OrderMasterConsts.UNPAID)){
            return "0/0";
        }
        else if(state.equals(OrderMasterConsts.PAID)){
            //取消订单操作距离飞机起飞还有days天
            long days = (orderMaster.getOrderDate().getTime() - today.getTime()) / 1000 / 60 / 60 / 24;
            if(days <= 15){
                //如果距离起飞半个月内取消订单收取50%手续费
                returnMoney /= 2;
            }
            //退还积分
            UserEntity user = orderMaster.getUserByUserNo();
            user.setCredit(user.getCredit() + returnCredit);
            return Integer.toString(returnMoney) + '/' + Integer.toString(returnCredit);
        }
        else{
            return "FAILED";
        }
    }
}
