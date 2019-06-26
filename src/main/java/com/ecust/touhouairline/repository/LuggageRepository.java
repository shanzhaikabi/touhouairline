package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.LuggageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuggageRepository extends JpaRepository<LuggageEntity,String> {
}
