package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.TmpEntity;
import com.ecust.touhouairline.repository.TmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private TmpRepository tmpRepository;
    String Login(String AccountName,String Password){
        Map<String,String> Ret = new HashMap<>();
        TmpEntity User = tmpRepository.findByAccountNameAndPassword(AccountName,Password);
        if(User == null){
            return "用户名或密码错误";
        }
        else{
            return "Success";
        }
    }
}
