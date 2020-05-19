package com.hobbify.service.dto;

import com.hobbify.model.Post;
import com.hobbify.service.HobbyService;
import com.hobbify.service.ProfileService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostDTOMapper {

    private final ProfileService profileService;
    private final HobbyService hobbyService;


    public PostDTOMapper(ProfileService profileService,
                         HobbyService hobbyService){
        this.profileService = profileService;
        this.hobbyService = hobbyService;
    }

    public Post getEntityFromDto(PostDTO postDTO){
        Post post = new Post();

        post.setContent(postDTO.getContent());
        post.setProfile(this.profileService.getByUuid(postDTO.getProfileUuid()));
        post.setPostDate(LocalDateTime.now());
        post.setHobby(this.hobbyService.getHobbyByUuid(postDTO.getHobbyUuid()));

        return post;
    }
}
