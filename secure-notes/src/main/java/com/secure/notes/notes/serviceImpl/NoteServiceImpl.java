package com.secure.notes.notes.serviceImpl;

import com.secure.notes.notes.models.Note;
import com.secure.notes.notes.repository.NoteRepository;
import com.secure.notes.notes.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author prabhakar, @Date 25-10-2024
 */
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUserName(userName);
        return this.noteRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String userName) {
        Note note = this.noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note Not Found.!"));
        note.setContent(content);
        return this.noteRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(Long noteId, String userName) {
        this.noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getListOfNoteForUser(String userName) {
        return this.noteRepository.findByOwnerUserName(userName);
    }
}
