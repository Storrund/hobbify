package com.hobbify.repository;

import com.hobbify.model.CustomUser;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends BaseRepository<CustomUser> {
    CustomUser findByUsername(String username );
}

