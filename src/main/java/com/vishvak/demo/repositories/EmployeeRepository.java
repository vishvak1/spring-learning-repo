package com.vishvak.demo.repositories;
import com.vishvak.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// You can use the path attribute of the below annotation to modify the sub-path of the endpoints for any Repositories/Entities
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JpaRepository Automatically interprets the name of the function when presented in camel-case and
    // does the operation automatically
    public List<Employee> findAll();

    // For example
    // If you want to find all the employees with the same last name
    // All you have to do is just suffix the word find with ByColumnNameInCamelCase. like this
    public List<Employee> findByLastName(String lastName);

    // You can also use custom SQL queries.
    @Query("SELECT e FROM Employee e WHERE e.email = :mailId")
    public List<Employee> findByMailId(String mailId);

    public void deleteById(Long id);

    public Employee save(Employee e);
}
