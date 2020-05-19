package com.hobbify.model;

import com.hobbify.model.auth.CustomUser;
import com.hobbify.model.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="post")
public class Post extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "profile_uuid", foreignKey = @ForeignKey(name = "FK_POST__PROFILE"))
    private Profile profile;

    @Column(name = "content", length=500)
    private String content;

    @OneToOne
    @JoinColumn(name = "hobby_uuid", foreignKey = @ForeignKey(name = "FK_POST__HOBBY"))
    private Hobby hobby;

    @Column(name = "post_date")
    private LocalDateTime date;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
