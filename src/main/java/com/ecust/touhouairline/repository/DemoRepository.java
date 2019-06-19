package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemoRepository extends JpaRepository<DemoEntity,Integer> {

    Optional<DemoEntity> findById(Integer id);
    <S extends DemoEntity> S save(S s);
}
