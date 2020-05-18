package com.hobbify.rest.auth;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hobbify.model.auth.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.hobbify.exception.ResourceConflictException;
import com.hobbify.model.auth.UserRequest;
import com.hobbify.service.auth.UserService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping(method = GET, value = "/user/{userUuid}")
  public CustomUser loadById(@PathVariable String userUuid) {
    return this.userService.findByUuid(userUuid);
  }

  @RequestMapping(method = GET, value = "/user/all")
  public List<CustomUser> loadAll() {
    return this.userService.findAll();
  }

  @RequestMapping(method = GET, value = "/user/reset-credentials")
  public ResponseEntity<Map> resetCredentials() {
    this.userService.resetCredentials();
    Map<String, String> result = new HashMap<>();
    result.put("result", "success");
    return ResponseEntity.accepted().body(result);
  }


  @RequestMapping(method = POST, value = "/signup")
  public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest,
      UriComponentsBuilder ucBuilder) {

    CustomUser existCustomUser = this.userService.findByUsername(userRequest.getUsername());
    if (existCustomUser != null) {
      throw new ResourceConflictException(userRequest.getUuid(), "Username already exists");
    }
    CustomUser customUser = this.userService.save(userRequest);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(customUser.getUuid()).toUri());
    return new ResponseEntity<CustomUser>(customUser, HttpStatus.CREATED);
  }

  @RequestMapping("/whoami")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public CustomUser user() {
    return (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
