package com.hobbify.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name="authority")
public class Authority extends BaseEntity implements GrantedAuthority {

    @Enumerated( EnumType.STRING)
    @Column(name="name")
    private UserRoleName name;

    @Override
    public String getAuthority() {
        return name.name();
    }

    public void setName(UserRoleName name) {
        this.name = name;
    }

    public UserRoleName getName() {
        return name;
    }


}
