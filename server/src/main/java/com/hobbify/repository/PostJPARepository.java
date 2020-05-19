package com.hobbify.repository;

import com.hobbify.model.Post;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface PostJPARepository extends BaseRepository<Post> {

    Slice<Post> findByHobbyUuidAndProfileUuid(String hobbyUuid, String profileUuid, Pageable pageable);

}
