package com.hobbify.service;

import java.util.List;
import com.hobbify.model.CustomUser;
import com.hobbify.model.UserRequest;

public interface UserService {
  void resetCredentials();

  CustomUser findById(Long id);

  CustomUser findByUsername(String username);

  List<CustomUser> findAll();

  CustomUser save(UserRequest user);
}
