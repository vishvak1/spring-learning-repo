package com.vishvak.demo.controllers;

import com.vishvak.demo.entities.Employee;
import com.vishvak.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

//  Use the below code for Constructor Injection

//    @Autowired
//    public EmployeeController(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{lastName}")
    public List<Employee> getAll(@PathVariable(name = "lastName") String lastName){
        return employeeRepository.findByLastName(lastName);
    }
}
