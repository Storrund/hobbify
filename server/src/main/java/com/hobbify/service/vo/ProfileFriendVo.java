package com.hobbify.service.vo;

public class ProfileFriendVo {

    private String firstProfile;

    private String secondProfile;

    private boolean accepted;

    public String getFirstProfile() {
        return firstProfile;
    }

    public void setFirstProfile(String firstProfile) {
        this.firstProfile = firstProfile;
    }

    public String getSecondProfile() {
        return secondProfile;
    }

    public void setSecondProfile(String secondProfile) {
        this.secondProfile = secondProfile;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
