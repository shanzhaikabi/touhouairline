package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,String> {
    CharacterEntity findByCharacterName(String characterName);
}
