package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.repository.ProfileJPARepository;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.dto.ProfileDTOMapper;
import com.hobbify.service.vo.ProfileVo;
import com.hobbify.service.vo.ProfileVoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileJPARepository profileJPARepository;
    private final ProfileDTOMapper profileDTOMapper;
    private final ProfileVoMapper profileVoMapper;

    public ProfileServiceImpl(
            ProfileJPARepository profileJPARepository,
            ProfileDTOMapper profileDTOMapper,
            ProfileVoMapper profileVoMapper){
        this.profileJPARepository = profileJPARepository;
        this.profileDTOMapper = profileDTOMapper;
        this.profileVoMapper = profileVoMapper;
    }

    @Transactional
    @Override
    public ProfileVo save(ProfileDTO profileDTO){
        Profile profile = profileDTOMapper.getEntityFromDto(profileDTO);
        profileJPARepository.save(profile);

        return profileVoMapper.getVoFromEntity(profile);
    }

    @Override
    public ProfileVo getByUserUuid(String userUuid){
        Profile profile = profileJPARepository.findByCustomUserUuid(userUuid);

        if(profile == null){
            return null;
        }

        return profileVoMapper.getVoFromEntity(profile);
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
