package com.hobbify.service;

import com.hobbify.service.dto.PostDTO;
import com.hobbify.service.vo.PostVo;

public interface PostService {

    PostVo save(PostDTO postDTO);

    PostVo getByHobbyUuid(String hobbyUuid, String profileUuid);
}
