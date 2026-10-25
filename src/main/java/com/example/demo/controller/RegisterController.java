package com.example.demo.controller;

import com.example.demo.dto.RegisterDTO;
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
    public ResponseEntity add(@RequestBody RegisterDTO registerDto){
        RegisterDTO registeredUser;
        if(!registerService.userExists(registerDto.getEmail())){
            registerService.registerUser(registerDto);
            return new ResponseEntity<>(registerDto, HttpStatus.CREATED);
        }

            throw new RuntimeException("User already exists with emailId "+registerDto.getEmail());
    }
}
