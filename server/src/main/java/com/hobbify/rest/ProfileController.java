package com.hobbify.rest;

import com.hobbify.model.Profile;
import com.hobbify.service.ProfileService;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.vo.ProfileVo;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private static final Logger logger = Logger.getLogger(ProfileController.class);

    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> saveProfile(@RequestBody ProfileDTO profileDTO) {
        ProfileVo profileVo = profileService.save(profileDTO);
        return new ResponseEntity<>(profileVo, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{userUuid}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> getProfileByUserUuid(@PathVariable String userUuid) {
        ProfileVo profileVo = this.profileService.getByUserUuid(userUuid);
        return new ResponseEntity<>(profileVo, HttpStatus.OK);
    }

}
