package com.arquitetura.hexagonal.application.domain.exception;

public class InvalidIdException extends Exception{
    public InvalidIdException(String message) {
        super(message);
    }
}
