package com.springboot.security.users.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Data
public class UpdateUserRequest {
    private String id;
    private String name;
    private String email;
    private String password;
}
