package com.hobbify.model;

import com.hobbify.model.auth.CustomUser;
import com.hobbify.model.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="profile",
        indexes = {@Index(name = "user_uuid_index",  columnList="custom_user_uuid", unique = true)})
public class Profile extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "custom_user_uuid", foreignKey = @ForeignKey(name = "FK_PROFILE__CUSTOM_USER"))
    private CustomUser customUser;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "profile_hobby",
            joinColumns = @JoinColumn(name = "profile_uuid", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "hobby_uuid", referencedColumnName = "uuid"))
    private Set<Hobby> hobbies;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
