package com.hobbify.repository;

import com.hobbify.model.auth.Authority;
import com.hobbify.model.auth.UserRoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(UserRoleName name);
}
