package com.vishvak.demo.dao.impl;

import com.vishvak.demo.dao.EmployeeDAO;
import com.vishvak.demo.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // You can use @PersistenceContext to inject an instance of EntityManager much like Autowiring

    @PersistenceContext
    private EntityManager entityManager;

    // You can use @Autowiring in the place of @PersistenceContext if you would like to

//    @Autowired
//    public EmployeeDAOImpl(EntityManager entityManager){
//        this.entityManager = entityManager;
//    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e from Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Long id) {
        Employee e = entityManager.find(Employee.class, id);
        return e;
    }

    // merge will insert a new record if the id is not provided however
    // if the id is provided then UPDATE operation happens instead of ADD

    // NOTE: For the addition of new record to be successful the strategy attribute of @GeneratedValue of the primary key
    // annotated with @Id should be in accordance with how the Database is configured.
    // For example, for the @GeneratedValue(strategy = GenerationType.IDENTITY) to work
    // The database table should be configured to auto-increment on the primary key.
    // For the @GeneratedValue(strategy = GenerationType.UUID) to work the database table should be
    // configured to take UUID as value for the primary key
    @Override
    public Employee save(Employee e) {
        Employee dbEmployee = entityManager.merge(e);
        return dbEmployee;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }
}
