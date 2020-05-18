package com.hobbify.service.exception;

public class HobbyNotFoundException extends RuntimeException {

    public HobbyNotFoundException(String message){ super(message); }

    public HobbyNotFoundException(){}
}
