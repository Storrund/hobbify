package com.hobbify.service.dto;

import com.hobbify.model.Hobby;
import com.hobbify.model.Post;
import com.hobbify.model.Profile;
import com.hobbify.model.auth.CustomUser;
import com.hobbify.service.HobbyService;
import com.hobbify.service.ProfileService;
import com.hobbify.service.auth.UserService;
import com.hobbify.service.vo.HobbyVo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
        post.setDate(LocalDateTime.now());
        post.setHobby(this.hobbyService.getHobbyByUuid(postDTO.getHobbyUuid()));

        return post;
    }
}
