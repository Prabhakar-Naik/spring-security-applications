package com.springboot.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;
}
