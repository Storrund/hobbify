package com.hobbify.service;

import com.hobbify.model.Post;
import com.hobbify.repository.PostJPARepository;
import com.hobbify.service.dto.PostDTO;
import com.hobbify.service.dto.PostDTOMapper;
import com.hobbify.service.vo.PostVo;
import com.hobbify.service.vo.PostVoMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostServiceImpl implements PostService {


    private PostJPARepository postJPARepository;
    private PostDTOMapper postDTOMapper;
    private PostVoMapper postVoMapper;

    public PostServiceImpl(
            PostJPARepository postJPARepository,
            PostDTOMapper postDTOMapper,
            PostVoMapper postVoMapper){
        this.postJPARepository = postJPARepository;
        this.postDTOMapper = postDTOMapper;
        this.postVoMapper = postVoMapper;
    }

    @Transactional
    @Override
    public PostVo save(PostDTO postDTO){
        Post post = postDTOMapper.getEntityFromDto(postDTO);
        postJPARepository.save(post);

        return postVoMapper.getVoFromEntity(post);
    }

    @Override
    public PostVo getByHobbyUuid(String hobbyUuid, String profileUuid){
        Post post = postJPARepository.findByHobbyUuid(hobbyUuid);

        if(post == null){
            return null;
        }

        return postVoMapper.getVoFromEntity(post);
    }
}
