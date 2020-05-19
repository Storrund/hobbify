package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.model.ProfileFriend;
import com.hobbify.repository.ProfileFriendJPARepository;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.dto.ProfileFriendDTO;
import com.hobbify.service.dto.ProfileFriendDTOMapper;
import com.hobbify.service.vo.ProfileFriendVoMapper;
import com.hobbify.service.vo.ProfileVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileFriendServiceImpl implements ProfileFriendService{

    private final ProfileFriendJPARepository profileFriendJPARepository;
    private final ProfileFriendDTOMapper profileFriendDTOMapper;
    private final ProfileFriendVoMapper profileFriendVoMapper;

    public ProfileFriendServiceImpl(
            ProfileFriendJPARepository profileFriendJPARepository,
            ProfileFriendDTOMapper profileFriendDTOMapper,
            ProfileFriendVoMapper profileFriendVoMapper){
        this.profileFriendJPARepository = profileFriendJPARepository;
        this.profileFriendDTOMapper = profileFriendDTOMapper;
        this.profileFriendVoMapper = profileFriendVoMapper;
    }

    @Transactional
    @Override
    public ProfileFriendDTO save(ProfileFriendDTO profileFriendDTO){
        ProfileFriend profileFriend = profileFriendDTOMapper.getEntityFromDto(profileFriendDTO);
        profileFriendJPARepository.save(profileFriend);

        return profileFriendDTO;
    }

}
