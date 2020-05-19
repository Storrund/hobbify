package com.hobbify.service;

import com.hobbify.service.dto.PostDTO;
import com.hobbify.service.vo.PostVo;

import java.util.List;

public interface PostService {

    PostVo save(PostDTO postDTO);

    List<PostVo> getAllByHobbyUuidAndProfileUuid(String hobbyUuid, String profileUuid);
}
