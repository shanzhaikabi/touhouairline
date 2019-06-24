package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.entity.UserEntityTmp;
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
    @Autowired
    private UserRepository userRepository;

    /**
     * 客户或管理员登录
     * @param AccountName 账户名
     * @param Password 密码
     * @param isCustomer 如果是客户登录则为true
     *                   如果是管理员登陆则为false
     * @return 成功返回Success，失败返回"用户名或密码错误"
     */
    public String Login(String AccountName,String Password,boolean isCustomer){
        UserEntity user = userRepository.findByUserNameAndPassword(AccountName,Password);
        if(user == null){
            return "用户名或密码错误";
        }
        else{
            //如果是客户登录且账户类型确实是客户则返回登录成功
            if(isCustomer && user.getCharacterByUserNo().getCharacterName().equals("客户")){
                return "success";
            }
            //如果管理端登录且账户类型不为客户也返回成功
            else if(!isCustomer && !user.getCharacterByUserNo().getCharacterName().equals("客户")){
                return "success";
            }
            //否则是客户登录管理员账户或管理员登陆客户账户，返回登录失败
            else{
                return "用户名或密码错误";
            }
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
