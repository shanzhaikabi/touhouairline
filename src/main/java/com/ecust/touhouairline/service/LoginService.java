package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.entity.UserEntityTmp;
import com.ecust.touhouairline.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param username 账户名
     * @param password 密码
     * @return 成功返回Success，失败返回"用户名或密码错误"
     */
    String Login(String username,String password){
        UserEntity User = userRepository.findByUsernameAndPassword(username,password).get();
        if(User == null){
            return "用户名或密码错误";
        }
        else{
            return "success";
        }
    }

    /**
     * @param userEntityTmp 封装好的用户信息
     * @return 成功返回success,失败返回失败原因
     */
    public String register(UserEntityTmp userEntityTmp){
        String checkUser = checkUserWhenRegister(userEntityTmp);
        if (checkUser.equals("yes")){
            userRepository.save(userEntityTmp.getUserEntity());
            return "success";
        }
        else return checkUser;
    }

    private String checkUserWhenRegister(UserEntityTmp user){
        if (userRepository.existsById(user.getUsername())) return "用户名已存在";
        if (user.getPassword().length() < 6 || user.getPassword().length() > 33) return "密码长度在6～11位";
        if (!user.getPassword().equals(user.getPasswordAgain())) return "两次密码不一致";
        if (user.getNickname().isEmpty()) return "昵称不能为空";
        if (user.getEmail().isEmpty()) return "邮箱不能为空";
        if (user.getPhone().isEmpty()) return "电话不能为空";
        return "yes";
    }

}
