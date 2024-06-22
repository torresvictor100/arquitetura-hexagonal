package com.arquitetura.hexagonal.application.domain.service;

import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.entity.Status;
import com.arquitetura.hexagonal.application.domain.exception.ProductFailedToCreate;
import com.arquitetura.hexagonal.application.domain.exception.ProductFailedToUpdate;
import com.arquitetura.hexagonal.application.domain.exception.ProductNotFoundException;
import com.arquitetura.hexagonal.application.domain.repository.ProductPersistenceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductPersistenceInterface productPersistenceInterface;

    public Product get(String id) {
        return productPersistenceInterface.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public Product create(String name, Integer price) throws Exception {
        Product product = new Product(name,price);
        product.IsValid();

        try {
            return productPersistenceInterface.save(product);
        }catch (Exception e){
            throw new ProductFailedToCreate("failure to create product");
        }
    }

    public Product enable(String id) throws Exception {

        return this.enable(this.get(id));
    }

    public Product updateProductPrice(String id, Integer price) {
        Product product = this.get(id);
        product.changePrice(price);
        return this.updeteProduct(product);
    }

    public Product updeteProduct(Product product) {
        try{
            return productPersistenceInterface.save(product);
        }catch(ProductFailedToUpdate e) {
            throw new ProductFailedToUpdate("failure to update product");
        }
    }

    public Product enable(Product product) throws Exception {
        try{
            if(product.getStatus() != Status.ENABLED){
                product.Enable();
            }
            return productPersistenceInterface.save(product);
        }catch (ProductFailedToUpdate e){
            throw new ProductFailedToUpdate("failure to update product");
        }
    }

    public Product disable(String id) throws Exception {
        return this.disable(this.get(id));
    }

    public Product disable(Product product) throws Exception {
        if(product.getStatus() != Status.DISABLED){
            product.Disable();
        }
        try {
            return productPersistenceInterface.save(product);
        }catch (Exception e){
            throw new ProductFailedToUpdate("failure to update product");
        }
    }
}
