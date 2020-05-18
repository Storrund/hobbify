package com.hobbify.repository.auth;

import com.hobbify.model.auth.CustomUser;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends BaseRepository<CustomUser> {
    CustomUser findByUsername(String username );
}

