package com.hobbify.repository;

import com.hobbify.model.Post;
import com.hobbify.repository.common.BaseRepository;

import java.util.List;

public interface PostJPARepository extends BaseRepository<Post> {

    List<Post> findAllByHobbyUuidAndProfileUuid(String hobbyUuid, String profileUuid);

}
