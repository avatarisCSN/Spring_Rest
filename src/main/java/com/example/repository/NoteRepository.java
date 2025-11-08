package com.example.repository;

import com.example.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    default void injectTestNotes() {
        save(new Note(null, "Test Note 1", "This is the first test note"));
        save(new Note(null, "Test Note 2", "This is the second test note"));
        save(new Note(null, "Another Note", "Some content here"));
    }
}
