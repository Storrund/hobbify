package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.model.ProfileFriend;
import com.hobbify.repository.ProfileFriendJPARepository;
import com.hobbify.repository.ProfileFriendPageRequester;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.dto.ProfileFriendDTO;
import com.hobbify.service.dto.ProfileFriendDTOMapper;
import com.hobbify.service.vo.ProfileFriendVo;
import com.hobbify.service.vo.ProfileFriendVoMapper;
import com.hobbify.service.vo.ProfileVo;
import com.hobbify.service.vo.ProfileVoMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileFriendServiceImpl implements ProfileFriendService{

    private final ProfileFriendJPARepository profileFriendJPARepository;
    private final ProfileFriendDTOMapper profileFriendDTOMapper;
    private final ProfileFriendVoMapper profileFriendVoMapper;

    private final ProfileService profileService;
    private final ProfileVoMapper profileVoMapper;

    public ProfileFriendServiceImpl(
            ProfileFriendJPARepository profileFriendJPARepository,
            ProfileFriendDTOMapper profileFriendDTOMapper,
            ProfileFriendVoMapper profileFriendVoMapper,
            ProfileService profileService,
            ProfileVoMapper profileVoMapper){
        this.profileFriendJPARepository = profileFriendJPARepository;
        this.profileFriendDTOMapper = profileFriendDTOMapper;
        this.profileFriendVoMapper = profileFriendVoMapper;
        this.profileService = profileService;
        this.profileVoMapper = profileVoMapper;
    }

    @Transactional
    @Override
    public ProfileFriendDTO save(ProfileFriendDTO profileFriendDTO){
        ProfileFriend profileFriend = profileFriendDTOMapper.getEntityFromDto(profileFriendDTO);
        profileFriendJPARepository.save(profileFriend);

        return profileFriendDTO;
    }

    @Transactional
    @Override
    public ProfileFriendVo accept(String profileFriendUuid){
        ProfileFriend profileFriend = this.profileFriendJPARepository.findByUuid(profileFriendUuid);
        profileFriend.setAccepted(true);
        this.profileFriendJPARepository.save(profileFriend);

        return this.profileFriendVoMapper.getVoFromEntity(profileFriend);
    }

    @Override
    public List<ProfileFriendVo> getFriendsRequests(String profileUuid, int limit, int offset){
        Pageable pageable = new ProfileFriendPageRequester(limit, offset);

        Slice<ProfileFriend> profileFriendSlice = this.profileFriendJPARepository.findBySecondProfileUuidAndAccepted(profileUuid, false, pageable);

        List<ProfileFriendVo> profileFriendVoList = profileFriendSlice
                .getContent()
                .stream()
                .map(profileFriendVoMapper::getVoFromEntity)
                .collect(Collectors.toList());

        return profileFriendVoList;
    }

    @Override
    public List<ProfileVo> getFriends(String profileUuid, int limit, int offset){
        Pageable pageable = new ProfileFriendPageRequester(limit, offset);

        Slice<ProfileFriend> profileFriendSlice = this.profileFriendJPARepository.findByFirstProfileUuidAndAccepted(profileUuid, true, pageable);

        List<Profile> profileList = new ArrayList<>();
        for(ProfileFriend profileFriend: profileFriendSlice){
            profileList.add(this.profileService.getByUuid(profileFriend.getSecondProfile().getUuid()));
        }

        List<ProfileVo> profileVoList = profileList
                .stream()
                .map(profileVoMapper::getVoFromEntity)
                .collect(Collectors.toList());

        return profileVoList;
    }

}
