package com.allesCoders.school.exception;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String msg) {
        super(msg);
    }
}
