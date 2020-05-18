package com.hobbify.service.dto;

import com.hobbify.service.vo.HobbyVo;

import java.util.Set;

public class ProfileDTO {

    private String customUserUuid;
    private Set<HobbyVo> hobbies;

    public String getCustomUserUuid() {
        return customUserUuid;
    }

    public void setCustomUserUuid(String customUserUuid) {
        this.customUserUuid = customUserUuid;
    }

    public Set<HobbyVo> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyVo> hobbies) {
        this.hobbies = hobbies;
    }
}
