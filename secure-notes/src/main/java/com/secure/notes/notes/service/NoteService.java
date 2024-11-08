package com.secure.notes.notes.service;

import com.secure.notes.notes.models.Note;

import java.util.List;

/**
 * @author prabhakar, @Date 25-10-2024
 */
public interface NoteService {

    Note createNoteForUser(String userName, String content);

    Note updateNoteForUser(Long noteId, String content, String userName);

    void deleteNoteForUser(Long noteId, String userName);

    List<Note> getListOfNoteForUser(String userName);
}
