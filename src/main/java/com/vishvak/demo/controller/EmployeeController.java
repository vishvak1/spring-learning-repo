package com.vishvak.demo.controller;

import com.vishvak.demo.entity.Employee;
import com.vishvak.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{lastName}")
    public List<Employee> getAllEmployeesByLastName(@PathVariable(name = "lastName") String lastName){
        return employeeService.findByLastName(lastName);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e){
        return employeeService.add(e);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long id){
        employeeService.delete(id);
    }
}
