package com.hobbify.service.vo;

import java.util.Set;

public class ProfileVo {

    private String uuid;

    private String customUserUuid;

    private String firstName;

    private String lastName;

    private Set<HobbyVo> hobbies;

    private String description;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<HobbyVo> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyVo> hobbies) {
        this.hobbies = hobbies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
