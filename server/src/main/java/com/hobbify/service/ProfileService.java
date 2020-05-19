package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.vo.ProfileVo;

import java.util.List;

public interface ProfileService {

    ProfileVo save(ProfileDTO profileDTO);

    ProfileVo getByUserUuid(String userUuid);

    List<ProfileVo> getAllByName(String name, int limit, int offset);

    Profile getByUuid(String uuid);

}
