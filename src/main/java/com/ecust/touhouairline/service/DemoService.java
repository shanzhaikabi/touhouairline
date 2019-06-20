package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.DemoEntity;
import com.ecust.touhouairline.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public DemoEntity getDemoEntityById(String id){
        DemoEntity entity = demoRepository.getOne(Integer.valueOf(id));
        return entity;
    }

    public DemoEntity getDemoEntityByNameAndPassword(String name,String password){
        return demoRepository.findByNameAndPassword(name,password);
    }
}
