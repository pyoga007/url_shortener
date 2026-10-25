package com.example.demo.service;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.repository.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository=registerRepository;
    }

    public UserResponseDTO registerUser(RegisterDTO registerDto) {
       User savedUser= registerRepository.save(new User(registerDto));
       return new UserResponseDTO(savedUser.getId(),savedUser.getEmail());
    }

    public boolean userExists(String email) {

       if(registerRepository.existsByEmail(email))
           throw new EmailAlreadyExistsException("User Already exists with this email id "+email);

        return false;
    }

}
