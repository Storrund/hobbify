package com.hobbify.service;

import com.hobbify.model.Post;
import com.hobbify.repository.PostJPARepository;
import com.hobbify.repository.PostPageRequester;
import com.hobbify.service.dto.PostDTO;
import com.hobbify.service.dto.PostDTOMapper;
import com.hobbify.service.vo.PostVo;
import com.hobbify.service.vo.PostVoMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<PostVo> getLastByHobbyUuidAndProfileUuid(String hobbyUuid, String profileUuid, int limit, int offset){
        Pageable pageable = new PostPageRequester(limit, offset);

        Slice<Post> test = postJPARepository.findByHobbyUuidAndProfileUuid(hobbyUuid, profileUuid, pageable);

        List<PostVo> postVoList = test
                .getContent()
                .stream()
                .map(postVoMapper::getVoFromEntity)
                .collect(Collectors.toList());

        return postVoList;
    }
}
