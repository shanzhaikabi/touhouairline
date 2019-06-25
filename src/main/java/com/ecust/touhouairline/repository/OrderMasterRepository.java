package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.OrderMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMasterEntity,String> {
    Collection<OrderMasterEntity> findAllByFlightNoAndStateIsNotIn(String flightno,Collection<String> states);
}
