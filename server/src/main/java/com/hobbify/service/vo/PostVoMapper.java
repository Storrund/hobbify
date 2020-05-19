package com.hobbify.service.vo;

import com.hobbify.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostVoMapper {

    public PostVo getVoFromEntity(Post post){
        PostVo postVo = new PostVo();

        postVo.setUuid(post.getUuid());
        postVo.setContent(post.getContent());
        postVo.setPostDate(post.getPostDate());
        postVo.setFirstName(post.getProfile().getCustomUser().getFirstname());
        postVo.setLastName(post.getProfile().getCustomUser().getLastname());

        return postVo;
    }
}
