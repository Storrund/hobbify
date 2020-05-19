package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.repository.ProfileJPARepository;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.dto.ProfileDTOMapper;
import com.hobbify.service.exception.ProfileNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileJPARepository profileJPARepository;
    private ProfileDTOMapper profileDTOMapper;

    public ProfileServiceImpl(
            ProfileJPARepository profileJPARepository,
            ProfileDTOMapper profileDTOMapper){
        this.profileJPARepository = profileJPARepository;
        this.profileDTOMapper = profileDTOMapper;
    }

    @Transactional
    @Override
    public ProfileDTO save(ProfileDTO profileDTO){
        Profile profile = profileDTOMapper.getEntityFromDto(profileDTO);
        profileJPARepository.save(profile);

        return profileDTO;
    }

    @Override
    public ProfileDTO getByUserUuid(String userUuid){
        Profile profile = profileJPARepository.findByCustomUserUuid(userUuid);

        if(profile == null){
            return null;
        }

        return profileDTOMapper.getDtoFromEntity(profile);
    }

    @Override
    public Profile getByUuid(String uuid){
        Profile profile = profileJPARepository.findByUuid(uuid);

        if(profile == null){
            return null;
        }

        return profile;
    }


}
