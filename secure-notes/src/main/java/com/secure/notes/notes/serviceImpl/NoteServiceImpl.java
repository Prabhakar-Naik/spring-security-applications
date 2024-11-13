package com.secure.notes.notes.serviceImpl;

import com.secure.notes.auditlog.service.AuditLogService;
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
    private final AuditLogService auditLogService;

    public NoteServiceImpl(NoteRepository noteRepository, AuditLogService auditLogService) {
        this.noteRepository = noteRepository;
        this.auditLogService = auditLogService;
    }

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUserName(userName);
        Note savedNote = noteRepository.save(note);
        auditLogService.logNoteCreation(userName, note);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String userName) {
        Note note = noteRepository.findById(noteId).orElseThrow(()
                -> new RuntimeException("Note not found"));
        note.setContent(content);
        Note updatedNote = noteRepository.save(note);
        auditLogService.logNoteUpdate(userName, note);
        return updatedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String userName) {
        Note note = noteRepository.findById(noteId).orElseThrow(
                () -> new RuntimeException("Note not found")
        );
        auditLogService.logNoteDeletion(userName, noteId);
        noteRepository.delete(note);
    }

    @Override
    public List<Note> getListOfNoteForUser(String userName) {
        return this.noteRepository.findByOwnerUserName(userName);
    }
}
