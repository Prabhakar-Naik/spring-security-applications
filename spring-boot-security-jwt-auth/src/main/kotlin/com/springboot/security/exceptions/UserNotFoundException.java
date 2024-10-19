package com.springboot.security.exceptions;

/**
 * @author prabhakar, @Date 19-09-2024
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
