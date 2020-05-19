package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.service.dto.ProfileDTO;

public interface ProfileService {

    ProfileDTO save(ProfileDTO profileDTO);

    ProfileDTO getByUserUuid(String userUuid);

    Profile getByUuid(String uuid);

}
