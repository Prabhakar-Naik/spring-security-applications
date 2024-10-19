package com.springboot.security.exceptions;

/**
 * @author prabhakar, @Date 20-09-2024
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
