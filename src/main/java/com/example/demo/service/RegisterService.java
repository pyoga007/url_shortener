package com.example.demo.service;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository=registerRepository;
    }

    public void registerUser(RegisterDTO registerDto) {
         registerRepository.save(new User(registerDto));
    }

    public boolean userExists(String email) {
       return registerRepository.existsByEmail(email);
    }
}
