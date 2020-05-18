package com.hobbify.service.dto;

import com.hobbify.model.Hobby;
import com.hobbify.model.Profile;
import com.hobbify.model.auth.CustomUser;
import com.hobbify.service.HobbyService;
import com.hobbify.service.auth.UserService;
import com.hobbify.service.vo.HobbyVo;
import com.hobbify.service.vo.HobbyVoMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProfileDTOMapper {

    private final UserService userService;
    private final HobbyService hobbyService;
    private final HobbyVoMapper hobbyVoMapper;

    public ProfileDTOMapper(UserService userService,
                            HobbyService hobbyService,
                            HobbyVoMapper hobbyVoMapper){
        this.userService = userService;
        this.hobbyService = hobbyService;
        this.hobbyVoMapper = hobbyVoMapper;
    }

    public ProfileDTO getDtoFromEntity(Profile profile){
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setCustomUserUuid(profile.getCustomUser().getUuid());

        Set<HobbyVo> hobbyVoList = new HashSet<>();
        for(Hobby hobby: profile.getHobbies()){
            hobbyVoList.add(this.hobbyVoMapper.getVoFromEntity(hobby));
        }
        profileDTO.setHobbies(hobbyVoList);

        return profileDTO;
    }

    public Profile getEntityFromDto(ProfileDTO profileDTO){
        Profile profile = new Profile();

        CustomUser customUser = this.userService.findByUuid(profileDTO.getCustomUserUuid());
        profile.setCustomUser(customUser);

        Set<Hobby> hobbySet = new HashSet<>();
        for(HobbyVo hobbyVo: profileDTO.getHobbies()){
            hobbySet.add(this.hobbyService.getHobbyByUuid(hobbyVo.getUuid()));
        }
        profile.setHobbies(hobbySet);

        return profile;
    }

}
