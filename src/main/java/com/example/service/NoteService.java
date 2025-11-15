package com.example.service;

import com.example.model.Note;
import com.example.model.NoteNotFoundException;
import com.example.repository.NoteRepository;

import java.util.Collection;
import java.util.List;

public interface NoteService  {

    public Collection<Note> getAllNotes() ;
    public Note add(Note note) ;
    public void deleteById(long id) throws NoteNotFoundException;
    public void update(long id, String title, String content) throws NoteNotFoundException ;
    public Note getById(long id) throws NoteNotFoundException ;
    public void addTestNotes();


}