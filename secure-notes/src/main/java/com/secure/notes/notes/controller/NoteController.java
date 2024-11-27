package com.secure.notes.notes.controller;

import com.secure.notes.notes.models.Note;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prabhakar, @Date 25-10-2024
 */
@RequestMapping(value = "/api/notes")
public interface NoteController {

    @PostMapping(value = "/createNote")
    Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails);

    @GetMapping(value = "/listOfNotesByUsername")
    List<Note> getListOfNotes(@AuthenticationPrincipal UserDetails userDetails);

    @PutMapping(value = "/updateNote/{noteId}")
    Note updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails);

    @DeleteMapping(value = "/deleteNoteById/{noteId}")
    void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails);



}
