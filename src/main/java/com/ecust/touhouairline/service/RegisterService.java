package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public String register(String username,String password){
        String checkPassword = checkPassword(password).equals("yes")
        if (checkPassword.equals("yes")){
            UserEntity user =
        }
        else return checkPassword;
    }

    public String checkPassword(String password){
        if (password.length() < 6 || password.length() > 33) return "密码长度在6～11位";
        return "yes";
    }
}
