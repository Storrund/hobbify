package com.hobbify.service;

import com.hobbify.model.Hobby;
import com.hobbify.service.vo.HobbyVo;

import java.util.List;

public interface HobbyService {

    List<HobbyVo> getAll();

    Hobby getHobbyByUuid(String uuid);
}
