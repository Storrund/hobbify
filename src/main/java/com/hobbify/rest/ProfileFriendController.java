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

    @RequestMapping(value="/{profileFriendUuid}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> accept(@PathVariable String profileFriendUuid) {
        return new ResponseEntity<>(profileFriendService.accept(profileFriendUuid), HttpStatus.CREATED);
    }

    @RequestMapping(value="/requests/{profileUuid}/{limit}/{offset}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> getFriendsRequests(@PathVariable String profileUuid, @PathVariable int limit, @PathVariable int offset) {
        return new ResponseEntity<>(this.profileFriendService.getFriendsRequests(profileUuid, limit, offset), HttpStatus.OK);
    }

    @RequestMapping(value="/{profileUuid}/{limit}/{offset}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> getFriends(@PathVariable String profileUuid, @PathVariable int limit, @PathVariable int offset) {
        return new ResponseEntity<>(this.profileFriendService.getFriends(profileUuid, limit, offset), HttpStatus.OK);
    }

}