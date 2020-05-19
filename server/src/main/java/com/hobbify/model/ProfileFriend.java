package com.hobbify.model;

import com.hobbify.model.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="profile_friend",
        indexes = {@Index(name = "profile_uuid_index",  columnList="first_profile_uuid, second_profile_uuid", unique = true)})
public class ProfileFriend extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "first_profile_uuid", foreignKey = @ForeignKey(name = "FK_PROFILE_FRIEND__PROFILE_FIRST"))
    private Profile firstProfile;

    @OneToOne
    @JoinColumn(name = "second_profile_uuid", foreignKey = @ForeignKey(name = "FK_PROFILE_FRIEND__PROFILE_SECOND"))
    private Profile secondProfile;

    private boolean accepted;

    public Profile getFirstProfile() {
        return firstProfile;
    }

    public void setFirstProfile(Profile firstProfile) {
        this.firstProfile = firstProfile;
    }

    public Profile getSecondProfile() {
        return secondProfile;
    }

    public void setSecondProfile(Profile secondProfile) {
        this.secondProfile = secondProfile;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
