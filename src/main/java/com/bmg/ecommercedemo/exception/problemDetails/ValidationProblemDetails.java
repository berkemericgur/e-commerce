package com.bmg.ecommercedemo.exception.problemDetails;

import lombok.Data;

import java.util.Map;

@Data
public class ValidationProblemDetails extends BaseProblemDetails {

    public ValidationProblemDetails(){

        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setType("http://mydomain.com/exception/validation");
        setStatus("500");
    }

    private Map<String, String> errors;
}
