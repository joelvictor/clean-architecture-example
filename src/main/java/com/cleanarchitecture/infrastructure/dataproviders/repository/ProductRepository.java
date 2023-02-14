package com.cleanarchitecture.infrastructure.dataproviders.repository;

import com.cleanarchitecture.infrastructure.dataproviders.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
