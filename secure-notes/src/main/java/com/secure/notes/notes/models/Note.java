package com.secure.notes.notes.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author prabhakar, @Date 25-10-2024
 */
@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String content;
    private String ownerUserName;
}
