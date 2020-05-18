package com.hobbify.service;

import com.hobbify.model.Hobby;
import com.hobbify.repository.HobbyJPARepository;
import com.hobbify.service.exception.HobbyNotFoundException;
import com.hobbify.service.vo.HobbyVo;
import com.hobbify.service.vo.HobbyVoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {

    private final HobbyJPARepository hobbyJPARepository;
    private final HobbyVoMapper hobbyVoMapper;

    public HobbyServiceImpl(HobbyJPARepository hobbyJPARepository,
                            HobbyVoMapper hobbyVoMapper){
        this.hobbyJPARepository = hobbyJPARepository;
        this.hobbyVoMapper = hobbyVoMapper;
    }

    @Override
    public List<HobbyVo> getAll(){
        List<Hobby> hobbies = this.hobbyJPARepository.findAll();

        List<HobbyVo> hobbyVoList = new ArrayList<>();
        for(Hobby hobby: hobbies){
            hobbyVoList.add(this.hobbyVoMapper.getVoFromEntity(hobby));
        }

        return hobbyVoList;
    }

    @Override
    public Hobby getHobbyByUuid(String uuid){
        return hobbyJPARepository.findById(uuid).orElseThrow(HobbyNotFoundException::new);
    }
}
