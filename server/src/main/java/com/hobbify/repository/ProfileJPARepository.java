package com.hobbify.repository;

import com.hobbify.model.Profile;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProfileJPARepository extends BaseRepository<Profile> {

    Profile findByCustomUserUuid(String userUuid);

    Profile findByUuid(String uuid);

    Slice<Profile> findByFirstNameLikeOrLastNameLike(String firstName, String lastName, Pageable pageable);
}
