package com.vishvak.demo.dao;

import com.vishvak.demo.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
