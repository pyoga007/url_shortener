package com.example.demo.controller;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private RegisterService registerService;

    public RegisterController(RegisterService registerService){
        this.registerService=registerService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> add(@RequestBody RegisterDTO registerDto){
        if(!registerService.userExists(registerDto.getEmail())){
           UserResponseDTO registeredUser= registerService.registerUser(registerDto);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        }

            throw new RuntimeException("User already exists with emailId "+registerDto.getEmail());
    }
}
