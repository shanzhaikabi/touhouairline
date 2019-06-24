package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterReopository extends JpaRepository<CharacterEntity,String> {
    CharacterEntity findByCharacterNo(String characterNo);
}
