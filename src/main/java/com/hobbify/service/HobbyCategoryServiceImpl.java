package com.hobbify.service;

import com.hobbify.model.HobbyCategory;
import com.hobbify.repository.HobbyCategoryJPARepository;
import com.hobbify.service.vo.HobbyCategoryVo;
import com.hobbify.service.vo.HobbyCategoryVoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyCategoryServiceImpl implements HobbyCategoryService {

    private HobbyCategoryJPARepository hobbyCategoryJPARepository;
    private HobbyCategoryVoMapper hobbyCategoryVoMapper;

    public HobbyCategoryServiceImpl(HobbyCategoryJPARepository hobbyCategoryJPARepository,
                                    HobbyCategoryVoMapper hobbyCategoryVoMapper){
        this.hobbyCategoryJPARepository = hobbyCategoryJPARepository;
        this.hobbyCategoryVoMapper = hobbyCategoryVoMapper;
    }

    @Override
    public List<HobbyCategoryVo> getAll(){
        List<HobbyCategory> hobbyCategories = this.hobbyCategoryJPARepository.findAll();

        List<HobbyCategoryVo> hobbyCategoryVoList = new ArrayList<>();
        for(HobbyCategory hobbyCategory: hobbyCategories){
            hobbyCategoryVoList.add(this.hobbyCategoryVoMapper.getVoFromEntity(hobbyCategory));
        }

        return hobbyCategoryVoList;
    }
}
