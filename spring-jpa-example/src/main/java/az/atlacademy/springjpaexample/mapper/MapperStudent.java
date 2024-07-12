package az.atlacademy.springjpaexample.mapper;

import az.atlacademy.springjpaexample.dao.entity.StudentEntity;
import az.atlacademy.springjpaexample.model.dto.StudentDto;
import az.atlacademy.springjpaexample.model.request.StudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperStudent {

    StudentEntity toEntity(StudentRequest studentDto) ;

    StudentDto toDto(StudentEntity studentEntity) ;
}
