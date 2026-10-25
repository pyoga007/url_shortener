package com.example.demo.entity;

import com.example.demo.dto.RegisterDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(RegisterDTO registerDTO){
        this.id=registerDTO.getId();
        this.email= registerDTO.getEmail();
        this.password= registerDTO.getPassword();
    }
}
