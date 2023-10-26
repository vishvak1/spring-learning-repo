package com.vishvak.demo.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingPathVariableException;

public class StudentBadRequestException extends RuntimeException {

    public StudentBadRequestException(String message){
        super(message);
    }
}
