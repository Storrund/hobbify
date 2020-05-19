package com.hobbify.service.vo;

import com.hobbify.model.Post;

public class PostVoMapper {

    public PostVo getVoFromEntity(Post post){
        PostVo postVo = new PostVo();

        postVo.setContent(post.getContent());
        postVo.setDate(post.getDate());
        postVo.setFirstName(post.getProfile().getCustomUser().getFirstname());
        postVo.setLastName(post.getProfile().getCustomUser().getLastname());

        return postVo;
    }
}
