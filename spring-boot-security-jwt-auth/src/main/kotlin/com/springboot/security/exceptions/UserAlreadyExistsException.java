package com.springboot.security.exceptions;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){
        super(message);
    }
}
