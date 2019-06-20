package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.User;
import com.ecust.touhouairline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 姚迟亮
 * 创建日期：2019-6-19
 **/
@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    /**
     * @param AccountName 账户名
     * @param Password 密码
     * @return 成功返回Success，失败返回"用户名或密码错误"
     */
    String Login(String AccountName,String Password){
        User User = userRepository.findByAccountNameAndPassword(AccountName,Password);
        if(User == null){
            return "用户名或密码错误";
        }
        else{
            return "Success";
        }
    }
}
