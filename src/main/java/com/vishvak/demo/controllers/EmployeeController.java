package com.vishvak.demo.controllers;

import com.vishvak.demo.dao.EmployeeDAO;
import com.vishvak.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

//  Use the below code for Constructor Injection

//    @Autowired
//    public EmployeeController(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeDAO.findAll();
    }
}
