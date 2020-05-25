package com.hobbify.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import com.hobbify.model.auth.UserRoleName;
import org.springframework.stereotype.Service;
import com.hobbify.model.auth.Authority;
import com.hobbify.repository.auth.AuthorityJPARepository;
import com.hobbify.service.auth.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

  private AuthorityJPARepository authorityJPARepository;

  public AuthorityServiceImpl(AuthorityJPARepository authorityJPARepository){
    this.authorityJPARepository = authorityJPARepository;
  }

  @Override
  public List<Authority> findByUuid(String uuid) {
    Authority auth = this.authorityJPARepository.getOne(uuid);
    List<Authority> auths = new ArrayList<>();
    auths.add(auth);
    return auths;
  }

  @Override
  public List<Authority> findByName(String name) {
    Authority auth = this.authorityJPARepository.findByName(UserRoleName.valueOf(name));
    List<Authority> auths = new ArrayList<>();
    auths.add(auth);
    return auths;
  }

}
