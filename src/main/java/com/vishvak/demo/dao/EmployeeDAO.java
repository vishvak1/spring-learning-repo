package com.vishvak.demo.dao;

import com.vishvak.demo.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee e);

    void deleteById(Long id);
}
