package com.example.service;

import com.example.model.Note;
import com.example.model.NoteNotFoundException;
import com.example.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;

    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    public Collection<Note> getAllNotes() {
        return repository.findAll();
    }
    public Note add(Note note) {

        repository.save( note);
        return note;
    }
    public void deleteById(long id) throws NoteNotFoundException {
        if (!repository.existsById(id)) {
            throw new NoteNotFoundException((int) id);
        }
        repository.deleteById(id);
    }
    public void update(long id, String title, String content) throws NoteNotFoundException {
        Note note = repository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));

        note.setTitle(title);
        note.setContent(content);
        repository.save(note);
    }
    public Note getById(long id) throws NoteNotFoundException {
        return repository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
    }
    public void addTestNotes() {
        repository.save(new Note("Title 1", "Content 1"));
        repository.save(new Note("Title 2", "Content 2"));
    }

}
