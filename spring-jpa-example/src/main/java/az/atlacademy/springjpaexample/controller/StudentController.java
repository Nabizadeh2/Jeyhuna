package az.atlacademy.springjpaexample.controller;

import az.atlacademy.springjpaexample.model.dto.StudentDto;
import az.atlacademy.springjpaexample.model.request.StudentRequest;
import az.atlacademy.springjpaexample.service.StudentService;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;
    @PostMapping
    public ResponseEntity<StudentDto>createStudent(@Valid @RequestBody StudentRequest studentRequest){


       return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>>findAllStudent(){
        return ResponseEntity.ok(studentService.findAllStudent());

    }

    @GetMapping("/{id}")

    public ResponseEntity<StudentDto>findById(@NotNull @PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/{id}")

    public ResponseEntity<Void>updateStudent(@PathVariable Long id,
                                             @RequestBody StudentDto studentDto){
        studentService.updateStudent(id,studentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")

    public  ResponseEntity<Void>deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
