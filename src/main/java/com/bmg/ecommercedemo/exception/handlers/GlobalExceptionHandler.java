package com.bmg.ecommercedemo.exception.handlers;
import com.bmg.ecommercedemo.exception.problemDetails.BusinessProblemDetails;
import com.bmg.ecommercedemo.exception.problemDetails.ValidationProblemDetails;
import com.bmg.ecommercedemo.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ValidationProblemDetails handlerValidationException(
            MethodArgumentNotValidException methodArgumentNotValidException){

        Map<String, String> validationErrors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
                .map(methodArgumentNotValidExceptions -> validationErrors
                        .put(methodArgumentNotValidExceptions.getField(), methodArgumentNotValidExceptions.getDefaultMessage()))
                .toList(); //collect(Collectors.toList()) immutable değil, değiştirilebilirler fakat daha esnektir.

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);

        return validationProblemDetails;

    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public BusinessProblemDetails handlerBusinessException(BusinessException businessException){

        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessException.getMessage());

        return businessProblemDetails;
    }
}
