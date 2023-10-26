package com.vishvak.demo.controllers;

import com.vishvak.demo.exceptions.StudentBadRequestException;
import com.vishvak.demo.exceptions.StudentNotFoundException;
import com.vishvak.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    List<Student> studentList;

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

    // The following GetMapping method is modified to take String input and then convert it to Integer value.
    // The parsing will throw an error if the value is a sequence of alphabetic characters as opposed to numeric characters.
    @GetMapping("/students/{studentId}")
    public List<Student> getStudent(@PathVariable(name = "studentId") String id){
        try {
            int studentId = Integer.parseInt(id);

            if(studentId < 0 || studentId >= studentList.size()){
                throw new StudentNotFoundException("Student id not found - " + id);
            }

            return List.of(studentList.get(studentId));
        }catch (NumberFormatException e){
            throw new StudentBadRequestException("Non-integer value provided - "+id);
        }
    }
}