package com.hobbify.repository;

import com.hobbify.model.Post;
import com.hobbify.repository.common.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface PostJPARepository extends BaseRepository<Post> {

    Slice<Post> findByHobbyUuidAndProfileUuidIn(String hobbyUuid, List<String> profileUuid, Pageable pageable);

}
