package com.arquitetura.hexagonal.adapters.cli;

import com.arquitetura.hexagonal.application.domain.entity.Product;
import com.arquitetura.hexagonal.application.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {
    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        try {
            if(args.length > 0 && args[0].equals("create1")){
                Product product = productService.create("product", 100);
                System.out.println("Product created successfully: " + product.toString());
            } else if (args.length > 0 && args[0].equals("create2")) {
                Product product = productService.create("product2", 200);
                System.out.println("Product created successfully: " + product.toString());
            }

        } catch (Exception e) {
            System.err.println("Failed to create product: " + e.getMessage());
        }
    }
}
