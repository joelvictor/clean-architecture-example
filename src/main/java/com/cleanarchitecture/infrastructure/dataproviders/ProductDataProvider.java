package com.cleanarchitecture.infrastructure.dataproviders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.domain.entities.Product;
import com.cleanarchitecture.domain.gateways.ProductGateway;
import com.cleanarchitecture.infrastructure.dataproviders.converters.ProductConverter;
import com.cleanarchitecture.infrastructure.dataproviders.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductDataProvider implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        var productEntity = ProductConverter.toProductEntity(product);
        productRepository.save(productEntity);
        return ProductConverter.toProduct(productEntity);
    }
}
