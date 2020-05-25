package com.hobbify.repository;

import com.hobbify.model.UserRoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hobbify.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(UserRoleName name);
}
