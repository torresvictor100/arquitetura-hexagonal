package com.arquitetura.hexagonal.application.domain.exception;

public class ProductFailedToCreate extends RuntimeException{
    public ProductFailedToCreate(String message) {
        super(message);
    }
}
