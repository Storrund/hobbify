package com.hobbify.service.vo;

import com.hobbify.model.ProfileFriend;
import org.springframework.stereotype.Component;

@Component
public class ProfileFriendVoMapper {

    public ProfileFriendVo getVoFromEntity(ProfileFriend profileFriend){
        ProfileFriendVo profileFriendVo = new ProfileFriendVo();

        profileFriendVo.setFirstProfile(profileFriend.getFirstProfile().getUuid());
        profileFriendVo.setSecondProfile(profileFriend.getSecondProfile().getUuid());
        profileFriendVo.setAccepted(profileFriend.isAccepted());

        return profileFriendVo;
    }
}
