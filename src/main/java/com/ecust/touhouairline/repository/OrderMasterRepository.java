package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.OrderMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderMasterRepository extends JpaRepository<OrderMasterEntity,String> {
}
