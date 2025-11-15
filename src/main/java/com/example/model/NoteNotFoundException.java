package com.example.model;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(long id) {
        super("Note with id " + id + " not found");
    }
}