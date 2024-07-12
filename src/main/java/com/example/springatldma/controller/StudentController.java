package com.example.springatldma.controller;

import com.example.springatldma.config.DatabaseConfiguration;
import com.example.springatldma.dao.StudentDao;
import com.example.springatldma.model.Student;
import com.example.springatldma.service.StudentService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) throws IllegalAccessException {
        if (id == null || id == 0) {
            throw new IllegalAccessException();
        }
        return ok(studentService.findById(id));
    }

    @PostMapping("/file-upload")
    public void uploadFile(@RequestBody byte[] file) {
        System.out.println(Arrays.toString(file));
    }


}
