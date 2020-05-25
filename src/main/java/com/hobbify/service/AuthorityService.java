package com.hobbify.service;

import com.hobbify.model.auth.Authority;

import java.util.List;


public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByName(String name);

}
