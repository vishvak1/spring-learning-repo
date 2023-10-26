package com.vishvak.demo.controllers;

import com.vishvak.demo.exceptions.StudentNotFoundException;
import com.vishvak.demo.model.Student;
import com.vishvak.demo.response.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    List<Student> studentList;

    // go to 07-global-exception-handler-demo to learn how to delegate exception handlers to a global central exception handler.

    @ExceptionHandler
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

    @PostConstruct
    public void init(){
        studentList = new ArrayList<>();

        studentList.add(new Student("Sarah", "Parker"));
        studentList.add(new Student("Jessica", "Jones"));
        studentList.add(new Student("Felina", "Catwell"));
        studentList.add(new Student("Hearthrob", "Thrombosis"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public List<Student> getStudent(@PathVariable(name = "studentId") int id){
        if(id < 0 || id >= studentList.size()){
            throw new StudentNotFoundException("Student id not found - " + id);
        }

        return List.of(studentList.get(id));
    }
}