package com.secure.notes.notes.controllerImpl;

import com.secure.notes.notes.controller.NoteController;
import com.secure.notes.notes.models.Note;
import com.secure.notes.notes.service.NoteService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author prabhakar, @Date 25-10-2024
 */
@RestController
public class NoteControllerImpl implements NoteController {

    private final NoteService noteService;

    public NoteControllerImpl(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public Note createNote(String content, UserDetails userDetails) {
        String userName = userDetails.getUsername();
        System.out.println("USER DETAILS: "+userName);
        return this.noteService.createNoteForUser(userName,content);
    }

    @Override
    public List<Note> getListOfNotes(UserDetails userDetails) {
        String userName = userDetails.getUsername();
        System.out.println("USER DETAILS: "+userName);
        return this.noteService.getListOfNoteForUser(userName);
    }

    @Override
    public Note updateNote(Long noteId, String content, UserDetails userDetails) {
        String userName = userDetails.getUsername();
        System.out.println("USER DETAILS: "+userName);
        return this.noteService.updateNoteForUser(noteId,content,userName);
    }

    @Override
    public void deleteNote(Long noteId, UserDetails userDetails) {
        String userName = userDetails.getUsername();
        System.out.println("USER DETAILS: "+userName);
        this.noteService.deleteNoteForUser(noteId, userName);
    }
}
