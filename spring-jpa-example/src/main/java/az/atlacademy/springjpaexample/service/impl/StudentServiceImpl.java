package az.atlacademy.springjpaexample.service.impl;

import az.atlacademy.springjpaexample.dao.entity.StudentEntity;
import az.atlacademy.springjpaexample.dao.repository.StudentRepository;
import az.atlacademy.springjpaexample.exception.StudentNotFoundException;
import az.atlacademy.springjpaexample.mapper.MapperStudent;
import az.atlacademy.springjpaexample.model.dto.StudentDto;
import az.atlacademy.springjpaexample.model.request.StudentRequest;
import az.atlacademy.springjpaexample.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final MapperStudent mapperStudent;
    private  final StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentRequest studentRequest) {
//        StudentEntity studentEntity= new StudentEntity();
//        studentEntity.setName(studentRequest.getName());
//        studentEntity.setSurname(studentRequest.getSurname());
//        studentEntity.setAge(studentRequest.getAge());
//       StudentEntity savedStudent= studentRepository.save(studentEntity);
//
//        StudentDto studentDto= new StudentDto();
//        studentDto.setName(savedStudent.getName());
//        studentDto.setSurname(savedStudent.getSurname());
//        studentDto.setAge(savedStudent.getAge());

        //return studentDto;

        StudentEntity studentEntity1= mapperStudent.toEntity((studentRequest));
        return mapperStudent.toDto(studentRepository.save(studentEntity1));
    }

    @Override
    public StudentDto findById(Long id) {
//        StudentEntity studentEntity=new StudentEntity();
//        studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(" " + id));
//        return new StudentDto(studentEntity.getId(),
//                studentEntity.getName(),
//                studentEntity.getSurname(),
//                studentEntity.getAge());

      return   studentRepository.findById(id)
                .map(mapperStudent::toDto)
                .orElseThrow(()->new StudentNotFoundException(""+id));

    }

    @Override
    public List<StudentDto> findAllStudent() {
//      List<StudentEntity> studentEntities=  studentRepository.findAll()
//                .stream().toList();
//      List<StudentDto>studentDtos=new ArrayList<>();
//      for (StudentEntity studentEntity:studentEntities){
//          studentDtos.add(new StudentDto(studentEntity.getId(),
//                  studentEntity.getName(),studentEntity.getSurname()
//          ,studentEntity.getAge()));
//      }
//        return studentDtos;

       return studentRepository.findAll().stream()
                .map(mapperStudent::toDto)
                .toList();
    }

    @Override
    public void updateStudent(Long id, StudentDto studentDto) {
        StudentEntity studentEntity=new StudentEntity();
        studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(" " + id));
        studentEntity.setName(studentDto.getName());
        studentEntity.setSurname(studentDto.getSurname());
        studentEntity.setAge(studentDto.getAge());
        studentRepository.save(studentEntity);

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);//belede yaza bilerik
        studentRepository.findById(id)
                .ifPresent(studentEntity -> studentRepository.deleteById(id));//belede

    }
}
