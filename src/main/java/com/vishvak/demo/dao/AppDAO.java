package com.vishvak.demo.dao;

import com.vishvak.demo.entity.InstructorDetail;

public interface AppDAO {
    InstructorDetail findById(int id);

    void delete(int id);
}
