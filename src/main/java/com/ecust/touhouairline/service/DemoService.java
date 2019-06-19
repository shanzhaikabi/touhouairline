package com.ecust.touhouairline.service;

import com.ecust.touhouairline.entity.DemoEntity;
import com.ecust.touhouairline.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    DemoRepository demoRepository;
    public DemoEntity getDemoById(Integer id){
        return demoRepository.getOne(id);
    }
}
