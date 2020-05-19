package com.hobbify.service.dto;

import com.hobbify.model.ProfileFriend;
import com.hobbify.service.ProfileService;
import org.springframework.stereotype.Component;

@Component
public class ProfileFriendDTOMapper {

    private final ProfileService profileService;

    public ProfileFriendDTOMapper(ProfileService profileService){
        this.profileService = profileService;
    }

    public ProfileFriend getEntityFromDto(ProfileFriendDTO profileFriendDTO){
        ProfileFriend profileFriend = new ProfileFriend();

        profileFriend.setFirstProfile(profileService.getByUuid(profileFriendDTO.getFirstProfileUuid()));
        profileFriend.setSecondProfile(profileService.getByUuid(profileFriendDTO.getSecondProfileUuid()));

        return profileFriend;
    }

}
