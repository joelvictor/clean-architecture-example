package com.cleanarchitecture.api.controllers;

import com.cleanarchitecture.application.models.request.CreateProductRequest;
import com.cleanarchitecture.application.models.response.CreateProductResponse;
import com.cleanarchitecture.application.usecases.CreateProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public CreateProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        return createProductUseCase.create(
                request.name(),
                request.description(),
                request.price()
        );
    }

}
