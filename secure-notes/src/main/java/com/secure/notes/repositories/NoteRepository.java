package com.secure.notes.repositories;

import com.secure.notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabhakar, @Date 25-10-2024
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOwnerUserName(String ownerUserName);
}