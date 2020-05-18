package com.hobbify.model;

import com.hobbify.model.auth.CustomUser;
import com.hobbify.model.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="profile")
public class Profile extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "uuid", foreignKey = @ForeignKey(name = "FK_PROFILE__CUSTOM_USER"))
    private CustomUser customUser;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "profile_hobby",
            joinColumns = @JoinColumn(name = "profile_uuid", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "hobby_uuid", referencedColumnName = "uuid"))
    private Set<Hobby> hobbies;

    public CustomUser getCustomUser() {
        return customUser;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}
