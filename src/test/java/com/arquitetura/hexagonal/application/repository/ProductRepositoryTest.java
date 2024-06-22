package com.arquitetura.hexagonal.application.repository;

import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.entity.ProductEntity;
import com.arquitetura.hexagonal.application.domain.repository.ProductPersistenceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductPersistenceInterface productPersistenceInterface;

    @Test
    public void testRepository() throws Exception {

        String productName = "product";
        Integer productPrice = 4;
        Product mockProduct = new Product(productName, productPrice);

        ProductEntity returnedProduct = productPersistenceInterface.save(mockProduct);

        assertNotNull(returnedProduct);
        assertEquals(mockProduct.getName(), returnedProduct.getName());
        assertEquals(productPrice, returnedProduct.getPrice());

        Product productFound = productPersistenceInterface.findById(returnedProduct.getId()).get();
        assertNotNull(productFound);

        productFound.changeName("product2");

        ProductEntity productUpdate = productPersistenceInterface.save(productFound);

        assertEquals("product2", productUpdate.getName());

    }
}
