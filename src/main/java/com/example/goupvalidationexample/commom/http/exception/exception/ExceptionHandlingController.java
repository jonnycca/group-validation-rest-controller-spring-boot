package com.example.goupvalidationexample.commom.http.exception.exception;

import com.example.goupvalidationexample.controller.exception.FieldValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {

  private static final String INVALID_REQUEST_MESSAGE = "Revise sua requisição";

  @ExceptionHandler(FieldValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  private String fieldValidation(FieldValidationException exception) {

    return INVALID_REQUEST_MESSAGE;
  }
}
