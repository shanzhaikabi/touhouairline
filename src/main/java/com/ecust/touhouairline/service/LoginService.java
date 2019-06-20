package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.TmpEntity;
import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.repository.TmpRepository;
import com.ecust.touhouairline.repository.UserRepository;
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
    private UserRepository userRepository;

    /**
     * @param AccountName 账户名
     * @param Password 密码
     * @return 成功返回Success，失败返回"用户名或密码错误"
     */
    String Login(String AccountName,String Password){
        TmpEntity User = tmpRepository.findByAccountNameAndPassword(AccountName,Password);
        if(User == null){
            return "用户名或密码错误";
        }
        else{
            return "Success";
        }
    }

    /**
     *
     * @param username
     * @param password
     * @return 成功返回success,失败返回失败原因
     */
    public String register(String username,String password,String passwordAgain){
        UserEntity user = userRepository.getOne(username);
        if (user != null) return "用户已存在";
        if (!password.equals(passwordAgain)) return "两次密码不一致";
        String checkPassword = checkPassword(password);
        if (checkPassword.equals("yes")){
            UserEntity userEntity = new UserEntity(username,password);
            userRepository.save(userEntity);
            return "success";
        }
        else return checkPassword;
    }

    public String checkPassword(String password){
        if (password.length() < 6 || password.length() > 33) return "密码长度在6～11位";
        return "yes";
    }
}
