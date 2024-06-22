package com.arquitetura.hexagonal.application.domain.exception;

public class InvalidPriceException extends Exception{
    public InvalidPriceException(String message) {
        super(message);
    }
}
