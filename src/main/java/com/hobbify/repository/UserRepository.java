package com.hobbify.repository;

import com.hobbify.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findByUsername(String username );
}

