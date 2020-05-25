package com.hobbify.service;

import com.hobbify.model.auth.CustomUser;
import com.hobbify.model.auth.UserRequest;

import java.util.List;

public interface UserService {
  void resetCredentials();

  CustomUser findById(String id);

  CustomUser findByUsername(String username);

  List<CustomUser> findAll();

  CustomUser save(UserRequest user);
}
