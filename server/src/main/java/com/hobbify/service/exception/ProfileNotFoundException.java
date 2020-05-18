package com.hobbify.service.exception;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException(String message){ super(message); }

    public ProfileNotFoundException(){}
}
