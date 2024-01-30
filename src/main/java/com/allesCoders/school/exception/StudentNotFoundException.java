package com.allesCoders.school.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
