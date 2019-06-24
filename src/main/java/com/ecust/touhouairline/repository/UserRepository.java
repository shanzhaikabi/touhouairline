package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findByUserNameAndPassword(String UserName, String Password);
}
