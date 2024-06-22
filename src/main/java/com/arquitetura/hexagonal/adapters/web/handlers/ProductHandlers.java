package com.arquitetura.hexagonal.adapters.web.handlers;

import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.exception.*;
import com.arquitetura.hexagonal.application.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductHandlers {
    @Autowired
    private ProductService productService;
    @QueryMapping
    public Product getProductById(@Argument String id){
        return productService.get(id);
    }
    @MutationMapping
    public Product createProduct(@Argument String name,@Argument Integer price)
            throws InvalidPriceException, InvalidNameException, InvalidStatusException, InvalidIdException {
        try {
            return productService.create(name, price);
        } catch (InvalidIdException | InvalidNameException | InvalidPriceException |
                 InvalidStatusException | ProductFailedToCreate e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred", e);
        }

    }

    @MutationMapping
    public Product updateProductPriceProduct(@Argument String productId, @Argument Integer price){
        return productService.updateProductPrice(productId, price);
    }

    @MutationMapping
    public Product enableProduct(@Argument String productId) throws Exception {
        return productService.enable(productId);

    }

    @MutationMapping
    public Product disableProduct(@Argument String productId) throws Exception {
            return productService.disable(productId);

    }

}
