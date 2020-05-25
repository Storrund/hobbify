package com.hobbify.service.vo;

import com.hobbify.model.HobbyCategory;
import org.springframework.stereotype.Component;

@Component
public class HobbyCategoryVoMapper {

    public HobbyCategoryVo getVoFromEntity(HobbyCategory hobbyCategory){
        HobbyCategoryVo hobbyCategoryVo = new HobbyCategoryVo();
        hobbyCategoryVo.setUuid(hobbyCategory.getUuid());
        hobbyCategoryVo.setName(hobbyCategory.getName());
        hobbyCategoryVo.setColor(hobbyCategory.getColor());

        return hobbyCategoryVo;
    }
}
