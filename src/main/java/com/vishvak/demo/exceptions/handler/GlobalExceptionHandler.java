package com.vishvak.demo.exceptions.handler;

import com.vishvak.demo.exceptions.StudentBadRequestException;
import com.vishvak.demo.exceptions.StudentNotFoundException;
import com.vishvak.demo.response.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // In this class you can create several exception handlers for different exceptions you can do so by mentioning the class
    // as a parameter in the @ExceptionHandler annotation.

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){ // Custom Exception class

        // Custom Error Response class.
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // This is using builder pattern

        // You can also use the following return statement.
        // return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentBadRequestException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentBadRequestException e){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
