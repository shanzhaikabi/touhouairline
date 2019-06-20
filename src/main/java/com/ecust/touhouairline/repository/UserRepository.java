package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByAccountNameAndPassword(String AccountName, String Password);
}
