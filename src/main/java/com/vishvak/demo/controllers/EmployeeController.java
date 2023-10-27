package com.vishvak.demo.controllers;

import com.vishvak.demo.dao.EmployeeDAO;
import com.vishvak.demo.entities.Employee;
import com.vishvak.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//  Use the below code for Constructor Injection

//    @Autowired
//    public EmployeeController(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") Long id){
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "employeeId") Long id){
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
