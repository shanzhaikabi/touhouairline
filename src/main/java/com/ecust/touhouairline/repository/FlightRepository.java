package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity,String> {
}
