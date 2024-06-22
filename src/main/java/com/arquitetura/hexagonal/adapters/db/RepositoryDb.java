package com.arquitetura.hexagonal.adapters.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryDb<T , ID> extends JpaRepository<T,ID> {
}
