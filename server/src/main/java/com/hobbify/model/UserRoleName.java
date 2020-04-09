package com.hobbify.model;

public enum UserRoleName {
    ROLE_USER,
    ROLE_ADMIN;

    public static UserRoleName getUserRole(String name){
        return UserRoleName.valueOf(name);
    }
}
