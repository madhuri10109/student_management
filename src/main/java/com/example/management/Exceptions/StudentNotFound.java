package com.example.management.Exceptions;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound(String message) {
        super(message);
    }

}
