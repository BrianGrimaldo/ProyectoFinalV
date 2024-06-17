package com.example.AgenciaAutos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja específicamente la ResourceNotFoundException
    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Maneja cualquier otro tipo de excepción no capturada específicamente
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
