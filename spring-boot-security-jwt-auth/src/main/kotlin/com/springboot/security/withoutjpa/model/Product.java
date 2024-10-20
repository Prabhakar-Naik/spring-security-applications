package com.springboot.security.withoutjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
}
