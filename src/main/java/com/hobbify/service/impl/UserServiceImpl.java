package com.hobbify.service.impl;

import java.util.List;

import com.hobbify.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hobbify.model.Authority;
import com.hobbify.model.UserRequest;
import com.hobbify.repository.UserRepository;
import com.hobbify.service.AuthorityService;
import com.hobbify.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthorityService authService;

  public void resetCredentials() {
    List<CustomUser> customUsers = userRepository.findAll();
    for (CustomUser customUser : customUsers) {
      customUser.setPassword(passwordEncoder.encode("123"));
      userRepository.save(customUser);
    }
  }

  @Override
  // @PreAuthorize("hasRole('USER')")
  public CustomUser findByUsername(String username) throws UsernameNotFoundException {
    CustomUser u = userRepository.findByUsername(username);
    return u;
  }

  @PreAuthorize("hasRole('ADMIN')")
  public CustomUser findById(Long id) throws AccessDeniedException {
    CustomUser u = userRepository.getOne(id);
    return u;
  }

  @PreAuthorize("hasRole('ADMIN')")
  public List<CustomUser> findAll() throws AccessDeniedException {
    List<CustomUser> result = userRepository.findAll();
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
    this.userRepository.save(customUser);
    return customUser;
  }

}
