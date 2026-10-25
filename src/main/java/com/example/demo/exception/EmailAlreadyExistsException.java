package com.example.demo.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    String message;
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
