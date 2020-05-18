package com.hobbify.rest;

import com.hobbify.service.ProfileService;
import com.hobbify.service.dto.ProfileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/profile/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveProfile(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO profileDtoSaved = profileService.save(profileDTO);
        return new ResponseEntity<>(profileDtoSaved, HttpStatus.CREATED);
    }

}
