package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.UserEntity;
import com.ecust.touhouairline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getUserEntityNameById(String id){
        UserEntity entity = UserRepository.getOne(Integer.valueOf(id));
        if (entity != null) return entity.getName();
        return null;
    }
}
