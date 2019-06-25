package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.FlightEntity;
import com.ecust.touhouairline.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collection;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity,String> {
    FlightEntity findByFlightNo(String flightNo);
    Collection<FlightEntity> findFlightEntitiesByDepartTimeBetweenAndDepartPlaceEqualsAndDestinationEquals(
            Timestamp departTime, Timestamp departTimeEnd, String departPlace, String destination);

}