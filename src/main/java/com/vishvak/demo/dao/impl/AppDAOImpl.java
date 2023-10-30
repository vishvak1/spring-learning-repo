package com.vishvak.demo.dao.impl;

import com.vishvak.demo.dao.AppDAO;
import com.vishvak.demo.entity.Instructor;
import com.vishvak.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public InstructorDetail findById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        entityManager.remove(instructorDetail);
    }
}
