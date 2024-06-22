package com.arquitetura.hexagonal.application.service;

import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.entity.ProductEntity;
import com.arquitetura.hexagonal.application.domain.entity.Status;
import com.arquitetura.hexagonal.application.domain.exception.ProductFailedToCreate;
import com.arquitetura.hexagonal.application.domain.exception.ProductNotFoundException;
import com.arquitetura.hexagonal.application.domain.repository.ProductPersistenceInterface;
import com.arquitetura.hexagonal.application.domain.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductPersistenceInterface productPersistenceInterface;
    @InjectMocks
    private ProductService productService;


    @Test
    public void testGetProductWhenProductExists() {

        Product mockProduct = new Product("product", 4);
        when(productPersistenceInterface.findById(mockProduct.getId())).thenReturn(Optional.of(mockProduct));


        ProductEntity returnedProduct = productService.get(mockProduct.getId());

        verify(productPersistenceInterface, times(1)).findById(mockProduct.getId());
        assertNotNull(returnedProduct);
        assertEquals(mockProduct.getId(), returnedProduct.getId());
    }

    @Test
    public void testGetProductWhenProductDoesNotExist() {

        String productId = "123";
        when(productPersistenceInterface.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productService.get(productId));
        verify(productPersistenceInterface, times(1)).findById(productId);
    }

    @Test
    public void testCreateProductWhenProductIsCreate() throws Exception {

        String productName = "product";
        Integer productPrice = 4;
        Product mockProduct = new Product(productName, productPrice);

        when(productPersistenceInterface.save(any(Product.class))).thenReturn(mockProduct);


        ProductEntity returnedProduct = productService.create(productName, productPrice);

        verify(productPersistenceInterface, times(1)).save(any(Product.class));
        assertNotNull(returnedProduct);
        assertEquals(mockProduct.getName(), returnedProduct.getName());
        assertEquals(productPrice, returnedProduct.getPrice());
    }

    @Test
    public void testCreateProductWhenSaveFails() throws Exception {
        String productName = "product";
        Integer productPrice = 4;
        when(productPersistenceInterface.save(any(Product.class))).thenThrow(new ProductFailedToCreate("Database error"));

        assertThrows(ProductFailedToCreate.class, () -> productService.create(productName, productPrice));
        verify(productPersistenceInterface, times(1)).save(any(Product.class));
    }

    @Test
    public void testDesableProductWhenProductIsCreate() throws Exception {

        String productName = "product";
        Integer productPrice = 0;
        Product mockProduct = new Product(productName, productPrice);
        mockProduct.Disable();

        when(productPersistenceInterface.save(any(Product.class))).thenReturn(mockProduct);


        ProductEntity returnedProduct = productService.disable(mockProduct);

        verify(productPersistenceInterface, times(1)).save(any(Product.class));
        assertNotNull(returnedProduct);
        assertEquals(mockProduct.getName(), returnedProduct.getName());
        assertEquals(productPrice, returnedProduct.getPrice());
        assertEquals(Status.DISABLED, returnedProduct.getStatus());
    }

    @Test
    public void testEnableProductWhenProductIsCreate() throws Exception {

        String productName = "product";
        Integer productPrice = 10;
        Product mockProduct = new Product(productName, productPrice);
        mockProduct.Enable();

        when(productPersistenceInterface.save(any(Product.class))).thenReturn(mockProduct);


        ProductEntity returnedProduct = productService.enable(mockProduct);

        verify(productPersistenceInterface, times(1)).save(any(Product.class));
        assertNotNull(returnedProduct);
        assertEquals(mockProduct.getName(), returnedProduct.getName());
        assertEquals(productPrice, returnedProduct.getPrice());
        assertEquals(Status.ENABLED, returnedProduct.getStatus());
    }
}
