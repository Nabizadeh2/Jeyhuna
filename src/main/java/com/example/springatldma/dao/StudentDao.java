package com.example.springatldma.dao;

import com.example.springatldma.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao<E> {
    Optional<E> findById(Long id);

    List<Student> getAllStudents();

}
