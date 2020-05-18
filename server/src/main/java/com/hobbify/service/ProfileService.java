package com.hobbify.service;

import com.hobbify.service.dto.ProfileDTO;

public interface ProfileService {

    ProfileDTO save(ProfileDTO profileDTO);

    ProfileDTO getByUserUuid(String userUuid);
}
