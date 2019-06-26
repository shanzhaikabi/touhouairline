package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.OrderDetailEntity;
import com.ecust.touhouairline.entity.OrderMasterEntity;
import com.ecust.touhouairline.service.DomainOrderService;
import com.ecust.touhouairline.utils.Result;
import com.ecust.touhouairline.utils.ResultWithSingleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DomainOrderController {
    @Autowired
    DomainOrderService domainOrderService;

    @PostMapping(value = "show_order_detail")
    public ModelMap showOrderDetail(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        OrderMasterEntity orderMaster = JSON.parseObject(JSON.toJSONString(params),OrderMasterEntity.class);
        Result result = domainOrderService.showOrderDetail(orderMaster);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "cancel_order")
    public ModelMap cancelOrder(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        OrderMasterEntity orderMaster = JSON.parseObject(JSON.toJSONString(params),OrderMasterEntity.class);
        ResultWithSingleMessage result = domainOrderService.cancelOrder(orderMaster);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "pay_order")
    public ModelMap payOrder(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        OrderMasterEntity orderMaster = JSON.parseObject(JSON.toJSONString(params),OrderMasterEntity.class);
        ResultWithSingleMessage result = domainOrderService.payOrder(orderMaster);
        map.put("result",result);
        return map;
    }


}
