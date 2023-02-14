package com.cleanarchitecture.domain.gateways;

import com.cleanarchitecture.domain.entities.Product;

public interface ProductGateway {
    Product save(Product product);
}
