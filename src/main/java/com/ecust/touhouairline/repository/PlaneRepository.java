package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.PlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneEntity,String> {
    PlaneEntity findByPlaneNo(String PlaneNo);
}
