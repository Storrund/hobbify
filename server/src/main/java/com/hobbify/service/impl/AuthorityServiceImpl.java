package com.hobbify.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hobbify.model.UserRoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hobbify.model.Authority;
import com.hobbify.repository.AuthorityRepository;
import com.hobbify.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

  private AuthorityRepository authorityRepository;

  public AuthorityServiceImpl(AuthorityRepository authorityRepository){
    this.authorityRepository = authorityRepository;
  }

  @Override
  public List<Authority> findById(Long id) {
    Authority auth = this.authorityRepository.getOne(id);
    List<Authority> auths = new ArrayList<>();
    auths.add(auth);
    return auths;
  }

  @Override
  public List<Authority> findByName(String name) {
    Authority auth = this.authorityRepository.findByName(UserRoleName.valueOf(name));
    List<Authority> auths = new ArrayList<>();
    auths.add(auth);
    return auths;
  }

}
