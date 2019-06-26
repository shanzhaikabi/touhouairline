package com.ecust.touhouairline.controller;

import com.alibaba.fastjson.JSON;
import com.ecust.touhouairline.entity.PassengerEntity;
import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.service.DomainUserInfoService;
import com.ecust.touhouairline.utils.MultiMessageResult;
import com.ecust.touhouairline.utils.ResultWithSingleMessage;
import com.ecust.touhouairline.utils.SingleMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DomainUserController {
    @Autowired
    DomainUserInfoService domainUserInfoService;

    @PostMapping(value = "change_user_info")
    public ModelMap changeUserInfo(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        UserEntity userEntity = JSON.parseObject(JSON.toJSONString(params.get("user")),UserEntity.class);
        UserEntity target = JSON.parseObject(JSON.toJSONString(params.get("target")),UserEntity.class);
        SingleMessageResult result = domainUserInfoService.changeUserInfo(userEntity,target);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "add_passenger")
    public ModelMap addPassenger(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String username = JSON.toJSONString(params.get("userName"));
        PassengerEntity target = JSON.parseObject(JSON.toJSONString(params.get("target")),PassengerEntity.class);
        MultiMessageResult result = domainUserInfoService.addPassenger(username,target);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "change_passenger")
    public ModelMap changePassenger(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String username = JSON.toJSONString(params.get("userName"));
        PassengerEntity target = JSON.parseObject(JSON.toJSONString(params.get("target")),PassengerEntity.class);
        MultiMessageResult result = domainUserInfoService.changePassenger(username,target);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "remove_passenger")
    public ModelMap removePassenger(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String username = JSON.toJSONString(params.get("user"));
        Integer target = (Integer) params.get("target");
        SingleMessageResult result = domainUserInfoService.deletePassenger(username,target);
        map.put("result",result);
        return map;
    }

    @PostMapping(value = "showpassengers")
    public ModelMap showPassengers(@RequestBody Map<String,Object> params){
        ModelMap map = new ModelMap();
        String username = JSON.toJSONString(params.get("user"));
        ResultWithSingleMessage result = domainUserInfoService.showPassages(username);
        map.put("result",result);
        return map;
    }
}
