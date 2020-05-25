package com.hobbify.service.auth;

import java.util.List;
import com.hobbify.model.auth.CustomUser;
import com.hobbify.model.auth.UserRequest;

public interface UserService {
  void resetCredentials();

  CustomUser findByUuid(String uuid);

  CustomUser findByUsername(String username);

  List<CustomUser> findAll();

  CustomUser save(UserRequest user);
}
