package com.arquitetura.hexagonal.application.domain.exception;

public class InvalidStatusException extends Exception{
    public InvalidStatusException(String message) {
        super(message);
    }
}
