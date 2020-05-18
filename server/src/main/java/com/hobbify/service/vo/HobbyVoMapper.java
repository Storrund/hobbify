package com.hobbify.service.vo;

import com.hobbify.model.Hobby;
import org.springframework.stereotype.Component;

@Component
public class HobbyVoMapper {

    public HobbyVo getVoFromEntity(Hobby hobby){
        HobbyVo hobbyVo = new HobbyVo();
        hobbyVo.setUuid(hobby.getUuid());
        hobbyVo.setName(hobby.getName());
        hobbyVo.setIconTag(hobby.getIconTag());
        hobbyVo.setHobbyCategoryUuid(hobby.getHobbyCategory().getUuid());

        return hobbyVo;
    }
}
