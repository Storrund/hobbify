package com.hobbify.service.dto;

public class PostDTO {

    private String profileUuid;

    private String hobbyUuid;

    private String content;

    public String getProfileUuid() {
        return profileUuid;
    }

    public void setProfileUuid(String profileUuid) {
        this.profileUuid = profileUuid;
    }

    public String getHobbyUuid() {
        return hobbyUuid;
    }

    public void setHobbyUuid(String hobbyUuid) {
        this.hobbyUuid = hobbyUuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
