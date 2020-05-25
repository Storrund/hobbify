package com.hobbify.repository;

import com.hobbify.model.ProfileFriend;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProfileFriendJPARepository extends BaseRepository<ProfileFriend> {

    ProfileFriend findByUuid(String uuid);

    Slice<ProfileFriend> findBySecondProfileUuidAndAccepted(String profileUuid, boolean accepted, Pageable pageable);

    Slice<ProfileFriend> findByFirstProfileUuidAndAccepted(String profileUuid, boolean accepted, Pageable pageable);

    ProfileFriend findByFirstProfileUuidAndSecondProfileUuidAndAccepted(String firstProfileUuid, String secondProfileUuid, boolean accepted);

}
