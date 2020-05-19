package com.hobbify.service.vo;

import java.util.Set;

public class ProfileVo {

    private String uuid;

    private String customUserUuid;

    private Set<HobbyVo> hobbies;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
