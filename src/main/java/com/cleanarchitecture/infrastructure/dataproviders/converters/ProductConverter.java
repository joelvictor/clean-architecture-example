package com.cleanarchitecture.infrastructure.dataproviders.converters;

import com.cleanarchitecture.domain.entities.Product;
import com.cleanarchitecture.infrastructure.dataproviders.entities.ProductEntity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductConverter(Long id,
                               String name,

                               String description,
                               BigDecimal price) {

    public ProductConverter(@NotNull ProductEntity product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public ProductConverter(@NotNull Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public static ProductEntity toProductEntity(Product product) {
        var productConverter = new ProductConverter(product);

        return ProductEntity.builder()
                .id(productConverter.id)
                .name(productConverter.name)
                .description(productConverter.description)
                .price(productConverter.price)
                .build();
    }

    public static Product toProduct(ProductEntity product) {
        var productConverter = new ProductConverter(product);

        return Product.builder()
                .id(productConverter.id)
                .name(productConverter.name)
                .description(productConverter.description)
                .price(productConverter.price)
                .build();
    }

}
