package com.hobbify.service.dto;

public class ProfileFriendDTO {

    private String firstProfileUuid;

    private String secondProfileUuid;

    public String getFirstProfileUuid() {
        return firstProfileUuid;
    }

    public void setFirstProfileUuid(String firstProfileUuid) {
        this.firstProfileUuid = firstProfileUuid;
    }

    public String getSecondProfileUuid() {
        return secondProfileUuid;
    }

    public void setSecondProfileUuid(String secondProfileUuid) {
        this.secondProfileUuid = secondProfileUuid;
    }
}
