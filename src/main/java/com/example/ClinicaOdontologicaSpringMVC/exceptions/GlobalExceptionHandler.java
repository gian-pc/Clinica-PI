package com.example.ClinicaOdontologicaSpringMVC.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{
    private MethodArgumentNotValidException exception;

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> manejarResourceNotFound(ResourceNotFoundException resourceNotFoundException) {
        Map<String, String> exceptionMessage = new HashMap<>();
        exceptionMessage.put("message", "Resource not found: " + resourceNotFoundException.getMessage());
        return exceptionMessage;
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> manejarBadRequest(BadRequestException badRequestException){
        Map<String, String> exceptionMessage = new HashMap<>();
        exceptionMessage.put("message","Bad Request: " + badRequestException.getMessage());

        return exceptionMessage;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> procesarValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> exceptionMessage = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            exceptionMessage.put(fieldName, errorMessage);
        });
        return exceptionMessage;
    }
}
