package com.bathaiah.studentapi.exception;

public class DuplicateRegisterNumberException extends RuntimeException {

    public DuplicateRegisterNumberException(String message) {
        super(message);
    }
}