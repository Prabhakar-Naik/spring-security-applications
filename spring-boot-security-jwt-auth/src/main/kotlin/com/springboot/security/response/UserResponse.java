package com.springboot.security.response;

import com.springboot.security.users.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author prabhakar, @Date 11-10-2024
 */
@Data
@AllArgsConstructor
public class UserResponse {
    private String response;
    private Users users;

}
