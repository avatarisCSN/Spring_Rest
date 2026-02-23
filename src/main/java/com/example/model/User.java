package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    private boolean enabled = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public User () {}


}
