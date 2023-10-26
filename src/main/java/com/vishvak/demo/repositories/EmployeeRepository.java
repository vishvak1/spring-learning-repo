package com.vishvak.demo.repositories;
import com.vishvak.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JpaRepository Automatically interprets the name of the function when presented in camel-case and
    // does the operation automatically
    public List<Employee> findAll();

    // For example
    // If you want to find all the employees with the same last name
    // All you have to do is just suffix the word find with ByColumnNameInCamelCase. like this
    public List<Employee> findByLastName(String lastName);

}
