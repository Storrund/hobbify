package com.hobbify.service.dto;

import com.hobbify.model.Profile;
import com.hobbify.model.ProfileFriend;
import org.springframework.stereotype.Component;

@Component
public class ProfileFriendDTOMapper {

    public ProfileFriendDTOMapper(){

    }

    public ProfileFriend getEntityFromDto(Profile firstProfile, Profile secondProfile){
        ProfileFriend profileFriend = new ProfileFriend();

        profileFriend.setFirstProfile(firstProfile);
        profileFriend.setSecondProfile(secondProfile);

        return profileFriend;
    }

}
