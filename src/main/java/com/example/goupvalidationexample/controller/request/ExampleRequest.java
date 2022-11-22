package com.example.goupvalidationexample.controller.request;

import com.example.goupvalidationexample.controller.validation.Field1NotPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleRequest {

    private String field1;

    @NotNull(groups = Field1NotPresent.class)
    private String field2;
}
