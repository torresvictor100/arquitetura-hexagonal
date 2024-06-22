package com.arquitetura.hexagonal.application.service;

import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.entity.ProductEntity;
import com.arquitetura.hexagonal.application.domain.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTest2 {

    @Autowired
    private ProductService productServiceAutowired;

    @Test
    public void testServiceAutowired() throws Exception {

        String productName = "product";
        Integer productPrice = 4;
        Product mockProduct = new Product(productName, productPrice);

        Product returnedProduct = productServiceAutowired.create(productName, productPrice);

        assertNotNull(returnedProduct);
        assertEquals(mockProduct.getName(), returnedProduct.getName());
        assertEquals(productPrice, returnedProduct.getPrice());

        Product productFound = productServiceAutowired.get(returnedProduct.getId());
        assertNotNull(productFound);

        productFound.changeName("product2");
        productFound.changePrice(0);

        ProductEntity productUpdate = productServiceAutowired.disable(productFound);

        assertEquals("product2", productUpdate.getName());

    }
}
