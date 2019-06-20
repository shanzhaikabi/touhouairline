package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.TmpEntity;
import com.ecust.touhouairline.repository.TmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 姚迟亮
 * 创建日期：2019-6-19
 **/
@Service
public class LoginService {
    //TODO：把TmpEntity和TmpRepository改为实际使用的Entity和Repository类
    @Autowired
    private TmpRepository tmpRepository;

    /**
     * @param AccountName 账户名
     * @param Password 密码
     * @return 成功返回Success，失败返回"用户名或密码错误"
     */
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
