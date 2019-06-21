package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.CharactertableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterReopository extends JpaRepository<CharactertableEntity,String> {

}
