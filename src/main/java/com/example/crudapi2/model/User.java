package com.example.crudapi2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5,max = 25)
    private String username;
    @Size(min = 3,max = 25)
    private String Password;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        Password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
