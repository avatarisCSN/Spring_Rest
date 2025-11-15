package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public Note() {  // 👈 обязателен для JPA
    }

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public Note( String title, String content) {
        this.title = title;
        this.content = content;
    }

    // сеттеры и геттеры можно оставить (или удалить — Lombok @Data их уже создаёт)
}