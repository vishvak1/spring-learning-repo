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
}
