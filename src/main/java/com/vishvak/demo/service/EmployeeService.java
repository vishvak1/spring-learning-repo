package com.vishvak.demo.service;

import com.vishvak.demo.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee add(Employee e);

    void delete(Long id);

    List<Employee> findByLastName(String lastName);
}