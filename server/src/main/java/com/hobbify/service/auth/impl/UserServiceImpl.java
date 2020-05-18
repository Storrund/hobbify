package com.hobbify.service.auth.impl;

import java.util.List;

import com.hobbify.model.auth.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hobbify.model.auth.Authority;
import com.hobbify.model.auth.UserRequest;
import com.hobbify.repository.auth.UserJPARepository;
import com.hobbify.service.auth.AuthorityService;
import com.hobbify.service.auth.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserJPARepository userJPARepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthorityService authService;

  public void resetCredentials() {
    List<CustomUser> customUsers = userJPARepository.findAll();
    for (CustomUser customUser : customUsers) {
      customUser.setPassword(passwordEncoder.encode("123"));
      userJPARepository.save(customUser);
    }
  }

  @Override
  // @PreAuthorize("hasRole('USER')")
  public CustomUser findByUsername(String username) throws UsernameNotFoundException {
    CustomUser u = userJPARepository.findByUsername(username);
    return u;
  }

  @PreAuthorize("hasRole('USER')")
  public CustomUser findByUuid(String uuid) throws AccessDeniedException {
    CustomUser u = userJPARepository.getOne(uuid);
    return u;
  }

  @PreAuthorize("hasRole('ADMIN')")
  public List<CustomUser> findAll() throws AccessDeniedException {
    List<CustomUser> result = userJPARepository.findAll();
    return result;
  }

  @Override
  public CustomUser save(UserRequest userRequest) {
    CustomUser customUser = new CustomUser();
    customUser.setUsername(userRequest.getUsername());
    customUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    customUser.setFirstname(userRequest.getFirstname());
    customUser.setLastname(userRequest.getLastname());
    List<Authority> auth = authService.findByName("ROLE_USER");
    customUser.setAuthorities(auth);
    this.userJPARepository.save(customUser);
    return customUser;
  }

}
