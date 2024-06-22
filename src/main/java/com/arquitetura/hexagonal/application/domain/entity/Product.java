package com.arquitetura.hexagonal.application.domain.entity;

import com.arquitetura.hexagonal.application.domain.exception.InvalidIdException;
import com.arquitetura.hexagonal.application.domain.exception.InvalidNameException;
import com.arquitetura.hexagonal.application.domain.exception.InvalidPriceException;
import com.arquitetura.hexagonal.application.domain.exception.InvalidStatusException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "products")
public class Product extends ProductEntity {

    public Product() {
    }

    public Product(String name, Integer price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.status = Status.DISABLED;
    }

    @Override
    public void IsValid() throws Exception {
        if(this.id.equals("") || this.id == null){
            throw new InvalidIdException("the name is id");
        }

        if(this.status.equals("")){
            throw new InvalidStatusException("the status must be anable or disabled");
        }

        if (this.status != Status.ENABLED
                && this.status != Status.DISABLED){
            throw new InvalidStatusException("the status must be anable or disabled");
        }

        if(this.price < 0){
            throw new InvalidPriceException("the price must be greater or equal zero");
        }

        if(this.name.equals("") || this.name == null){
            throw new InvalidNameException("the name is mandatory");
        }


    }

    @Override
    public void Enable() throws Exception{
        if (this.price > 0) {
            this.status = Status.ENABLED;
        }else {
            throw new InvalidStatusException("Price must be greater than zero to enable the product.");
        }
    }

    public void changeName(String name){
        this.name = name;
    }

    @Override
    public void Disable() throws Exception {
        if (this.price == 0) {
            this.status = Status.DISABLED;
        }else {
            throw new InvalidStatusException("the price must be zero in order to have the prodct disable");
        }

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void changePrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
