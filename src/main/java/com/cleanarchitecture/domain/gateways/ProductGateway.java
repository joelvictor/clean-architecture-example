package com.cleanarchitecture.domain.gateways;

import com.cleanarchitecture.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGateway extends JpaRepository<Product, Long> {
}
