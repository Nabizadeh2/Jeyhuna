package com.example.springatldma.service;

import com.example.springatldma.dao.StudentDao;
import com.example.springatldma.exception.StudentNotFoundException;
import com.example.springatldma.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentDao<Student> studentDao;

    public Student findById(Long id) {
        return studentDao.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));


    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
