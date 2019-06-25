package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,String> {
}
