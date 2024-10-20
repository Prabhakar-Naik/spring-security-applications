package com.springboot.security.users.request;

import lombok.Data;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Data
public class UserResponse {
    private String id;
    private String name;
    private String email;
}
