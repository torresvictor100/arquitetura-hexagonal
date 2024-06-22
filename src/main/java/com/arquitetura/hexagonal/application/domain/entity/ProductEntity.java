package com.arquitetura.hexagonal.application.domain.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ProductEntity {
    @Id
    protected String id;
    protected String name;
    protected Integer price;
    protected Status status;

    public abstract void IsValid() throws Exception;
    public abstract void Enable() throws Exception;
    public abstract void Disable() throws Exception;
    public abstract String getId();
    public abstract String getName();
    public abstract Integer getPrice();
    public abstract Status getStatus();
    public abstract void changePrice(Integer price) throws Exception;
}
