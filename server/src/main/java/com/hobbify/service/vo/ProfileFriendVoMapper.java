package com.hobbify.service.vo;

import com.hobbify.model.ProfileFriend;
import org.springframework.stereotype.Component;

@Component
public class ProfileFriendVoMapper {

    private final ProfileVoMapper profileVoMapper;

    public ProfileFriendVoMapper(
            ProfileVoMapper profileVoMapper){
        this.profileVoMapper = profileVoMapper;
    }

    public ProfileFriendVo getVoFromEntity(ProfileFriend profileFriend){
        ProfileFriendVo profileFriendVo = new ProfileFriendVo();

        profileFriendVo.setUuid(profileFriend.getUuid());
        profileFriendVo.setFirstProfile(profileFriend.getFirstProfile().getUuid());
        profileFriendVo.setSecondProfile(profileFriend.getSecondProfile().getUuid());
        profileFriendVo.setAccepted(profileFriend.isAccepted());

        profileFriendVo.setFirstProfileVo(this.profileVoMapper.getVoFromEntity(profileFriend.getFirstProfile()));

        return profileFriendVo;
    }
}
