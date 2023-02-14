package com.cleanarchitecture.application.usecases;

import com.cleanarchitecture.application.models.response.CreateProductResponse;
import com.cleanarchitecture.domain.entities.Product;
import com.cleanarchitecture.domain.gateways.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductResponse create(String name, String description, BigDecimal price) {
        var product = new Product(name, description, price);
        product = productGateway.save(product);
        return new CreateProductResponse(product);
    }

}
