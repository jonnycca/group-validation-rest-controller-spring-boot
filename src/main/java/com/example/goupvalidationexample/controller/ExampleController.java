package com.example.goupvalidationexample.controller;

import com.example.goupvalidationexample.controller.exception.FieldValidationException;
import com.example.goupvalidationexample.controller.request.ExampleRequest;
import com.example.goupvalidationexample.controller.validation.Field1NotPresent;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.*;
import java.util.Set;

@RestController
@Validated
public class ExampleController {

    @PostMapping("/example")
    public String execute(@Valid @RequestBody ExampleRequest request) throws FieldValidationException {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();
            checkIfField1IsNotPresent(request, validator);

            return "validation ok, field 2 present when field 1 not present";
        }
    }

    private void checkFieldErrors(Set<ConstraintViolation<ExampleRequest>> violations) throws FieldValidationException {
        if (violations.isEmpty()) return;
        FieldValidationException exception = new FieldValidationException();
        exception.setViolations(violations);
        throw exception;
    }
    private void checkIfField1IsNotPresent(ExampleRequest request, Validator validator) throws FieldValidationException {
        if(request.getField1() == null){
            Set<ConstraintViolation<ExampleRequest>> violations =
                    validator.validate(request, Field1NotPresent.class);
            checkFieldErrors(violations);
        }
    }
}
