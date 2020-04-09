package com.hobbify.service;

import java.util.List;
import com.hobbify.model.Authority;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByName(String name);

}
