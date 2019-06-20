package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.DemoEntity;
import com.ecust.touhouairline.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public String getDemoEntityNameById(String id){
        DemoEntity entity = demoRepository.getOne(Integer.valueOf(id));
        if (entity != null) return entity.getName();
        return null;
    }
}
