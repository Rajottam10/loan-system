package com.fl.cbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFound exception){
        ErrorResponse customerNotFound = new ErrorResponse(LocalDateTime.now(), exception.getMessage());
        return new ResponseEntity<>(customerNotFound, HttpStatus.NOT_FOUND);
    }
}
