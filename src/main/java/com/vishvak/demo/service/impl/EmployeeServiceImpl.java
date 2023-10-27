package com.vishvak.demo.service.impl;

import com.vishvak.demo.entities.Employee;
import com.vishvak.demo.repositories.EmployeeRepository;
import com.vishvak.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // The orElse is part of Optional class. This is introduced here because by default (i.e., you don't define a findById() method
    // in the Repository interface) then the default implementation of findById() returns the object wrapped in Optional Container.
    // like this Optional<Employee> findById(Long id)
    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);

        // You can also use the following
        // return employeeRepository.findById(id).get();
    }

    @Override
    public Employee add(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }
}
