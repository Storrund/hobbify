package com.hobbify.repository;

import com.hobbify.model.Post;
import com.hobbify.repository.common.BaseRepository;

public interface PostJPARepository extends BaseRepository<Post> {

    Post findByHobbyUuid(String hobbyUuid);

}
