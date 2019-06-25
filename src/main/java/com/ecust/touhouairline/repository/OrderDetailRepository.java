package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,String> {
}
