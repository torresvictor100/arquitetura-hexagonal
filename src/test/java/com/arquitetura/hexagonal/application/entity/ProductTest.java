package com.arquitetura.hexagonal.application.entity;


import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.exception.InvalidNameException;
import com.arquitetura.hexagonal.application.domain.exception.InvalidPriceException;
import com.arquitetura.hexagonal.application.domain.exception.InvalidStatusException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ProductTest {

    @Test
    public void product() throws Exception {
        Product product = new Product("product", 0);
        Assertions.assertThrows(InvalidStatusException.class, () -> product.Enable());
        product.changePrice(2);
        Assertions.assertEquals(2, product.getPrice());
        product.Enable();
        Assertions.assertThrows(InvalidStatusException.class, () -> product.Disable());
        product.changePrice(0);
        product.Disable();
    }

    @Test
    public void validTest(){
        Product product = new Product( "", -1);
        Assertions.assertThrows(InvalidPriceException.class, () -> product.IsValid());
        product.changePrice(1);
        Assertions.assertThrows(InvalidNameException.class, () -> product.IsValid());
    }
}
