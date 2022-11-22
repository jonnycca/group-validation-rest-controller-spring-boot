package com.example.goupvalidationexample.controller.exception;

import com.example.goupvalidationexample.controller.request.ExampleRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Getter
@Setter
public class FieldValidationException extends Exception{

    private Set<ConstraintViolation<ExampleRequest>> violations;
}
