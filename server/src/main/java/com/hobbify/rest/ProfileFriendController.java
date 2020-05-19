package com.hobbify.rest;


import com.hobbify.service.ProfileFriendService;
import com.hobbify.service.dto.ProfileFriendDTO;
import com.hobbify.service.vo.ProfileVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/profile-friend", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileFriendController {

    private ProfileFriendService profileFriendService;

    public ProfileFriendController(ProfileFriendService profileFriendService){
        this.profileFriendService = profileFriendService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> saveFriendRequest(@RequestBody ProfileFriendDTO profileFriendDTO) {
        return new ResponseEntity<>(profileFriendService.save(profileFriendDTO), HttpStatus.CREATED);
    }

}