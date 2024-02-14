package com.programmingtechie.productservice.handler;

import com.programmingtechie.productservice.dto.ErrorListResponse;
import com.programmingtechie.productservice.dto.ErrorResponse;
import com.programmingtechie.productservice.enums.ProductEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorListResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field,message);
        });

        ErrorListResponse response = new ErrorListResponse();
        List<ErrorResponse> lErrors = new ArrayList<>();
        ErrorResponse errorResponse = new ErrorResponse();

        Map.Entry<String,String> firstEntry = errors.entrySet().iterator().next();
        errorResponse.setErrorMessage(firstEntry.getKey() + " " + firstEntry.getValue());
        lErrors.add(errorResponse);
        response.setMessageCode(ProductEnum.INVALID_ARGUMENTS.getErrorCode());
        response.setMessage(ProductEnum.INVALID_ARGUMENTS.getMessage());
        response.setErrors(lErrors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
