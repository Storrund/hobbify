package com.hobbify.service.auth;

import java.util.List;
import com.hobbify.model.auth.Authority;

public interface AuthorityService {
  List<Authority> findByUuid(String uuid);

  List<Authority> findByName(String name);

}
