package com.arquitetura.hexagonal.application.domain.exception;

public class ProductFailedToUpdate extends RuntimeException{
    public ProductFailedToUpdate(String message) {
        super(message);
    }
}
