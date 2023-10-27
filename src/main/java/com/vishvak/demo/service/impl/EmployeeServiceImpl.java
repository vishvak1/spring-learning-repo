package com.vishvak.demo.service.impl;

import com.vishvak.demo.dao.EmployeeDAO;
import com.vishvak.demo.entities.Employee;
import com.vishvak.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee add(Employee e) {
        return employeeDAO.save(e);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        employeeDAO.deleteById(id);
    }
}
