package com.cleanarchitecture.infrastructure.configurations;

import com.tngtech.archunit.thirdparty.com.google.common.base.CaseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static com.tngtech.archunit.thirdparty.com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

@RestControllerAdvice
public class ErrorHandlerMiddleware {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<BadRequestDetail> details = ex.getBindingResult().getFieldErrors().stream().map(error -> {
            var campo = CaseFormat.LOWER_CAMEL.to(LOWER_UNDERSCORE, error.getField());
            return new BadRequestDetail(campo, error.getDefaultMessage(), error.getCode());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }

}
