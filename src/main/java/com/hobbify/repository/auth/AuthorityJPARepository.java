package com.hobbify.repository.auth;

import com.hobbify.model.auth.UserRoleName;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hobbify.model.auth.Authority;

public interface AuthorityJPARepository extends BaseRepository<Authority> {
  Authority findByName(UserRoleName name);
}
