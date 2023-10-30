package com.vishvak.demo.dao;

import com.vishvak.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void delete(int id);
}