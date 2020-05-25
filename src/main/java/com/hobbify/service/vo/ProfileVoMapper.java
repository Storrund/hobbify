package com.hobbify.service.vo;

import com.hobbify.model.Hobby;
import com.hobbify.model.Post;
import com.hobbify.model.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProfileVoMapper {

    private final HobbyVoMapper hobbyVoMapper;

    public ProfileVoMapper(HobbyVoMapper hobbyVoMapper){
        this.hobbyVoMapper = hobbyVoMapper;
    }

    public ProfileVo getVoFromEntity(Profile profile){
        ProfileVo profileVo = new ProfileVo();

        profileVo.setUuid(profile.getUuid());
        profileVo.setCustomUserUuid(profile.getCustomUser().getUuid());

        profileVo.setFirstName(profile.getFirstName());
        profileVo.setLastName(profile.getLastName());

        Set<HobbyVo> hobbyVoList = new HashSet<>();
        for(Hobby hobby: profile.getHobbies()){
            hobbyVoList.add(this.hobbyVoMapper.getVoFromEntity(hobby));
        }
        profileVo.setHobbies(hobbyVoList);

        profileVo.setDescription(profile.getDescription());

        return profileVo;
    }
}
