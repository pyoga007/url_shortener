package com.example.demo.dto;

public class UserResponseDTO {
    private Long id;
    private String email;

    public UserResponseDTO(Long id,String email){
        this.id=id;
        this.email=email;
    }
}
