package com.hobbify.service;

import com.hobbify.service.dto.ProfileFriendDTO;
import com.hobbify.service.vo.ProfileFriendVo;
import com.hobbify.service.vo.ProfileVo;

import java.util.List;

public interface ProfileFriendService {

    ProfileFriendDTO save(ProfileFriendDTO profileFriendDTO);

    ProfileFriendVo accept(String profileFriendUuid);

    List<ProfileFriendVo> getFriendsRequests(String profileUuid, int limit, int offset);

    List<ProfileVo> getFriends(String profileUuid, int limit, int offset);

}
