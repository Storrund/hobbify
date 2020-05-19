package com.hobbify.service;

import com.hobbify.model.HobbyCategory;
import com.hobbify.service.vo.HobbyCategoryVo;
import com.hobbify.service.vo.HobbyVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HobbyCategoryService {

    List<HobbyCategoryVo> getAll();
}
