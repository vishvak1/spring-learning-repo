package com.vishvak.demo.controllers;

import com.vishvak.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/students/{studentId}")
    public List<Student> getStudent(@PathVariable(name = "studentId") int id){
        return List.of(studentList.get(id));
    }
}