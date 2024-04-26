package com.bmg.ecommercedemo.exception.problemDetails;

public class BusinessProblemDetails extends BaseProblemDetails{

    public BusinessProblemDetails(){

        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("500");
    }
}
