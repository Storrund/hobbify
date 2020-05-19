package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.vo.ProfileVo;

public interface ProfileService {

    ProfileVo save(ProfileDTO profileDTO);

    ProfileVo getByUserUuid(String userUuid);

    Profile getByUuid(String uuid);

}
