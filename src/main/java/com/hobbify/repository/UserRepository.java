package com.hobbify.repository;

import com.hobbify.model.auth.CustomUser;
import com.hobbify.repository.common.BaseRepository;

public interface UserRepository extends BaseRepository<CustomUser> {
    CustomUser findByUsername(String username );
}

