package com.arquitetura.hexagonal.application.domain.entity;

public enum Status {
    DISABLED("disabled"),
    ENABLED("enable");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
