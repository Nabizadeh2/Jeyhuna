package az.atlacademy.springjpaexample.model.dto;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    Long id;
    String name;
    String surname;
    int age;


}
