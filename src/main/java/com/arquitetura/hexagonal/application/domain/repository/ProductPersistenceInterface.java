package com.arquitetura.hexagonal.application.domain.repository;

import com.arquitetura.hexagonal.adapters.db.RepositoryDb;
import com.arquitetura.hexagonal.application.domain.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPersistenceInterface extends RepositoryDb<Product, String> {
}
