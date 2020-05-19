package com.hobbify.repository;

import com.hobbify.model.Profile;
import com.hobbify.repository.common.BaseRepository;

public interface ProfileJPARepository extends BaseRepository<Profile> {

    Profile findByCustomUserUuid(String userUuid);

    Profile findByUuid(String uuid);

}
