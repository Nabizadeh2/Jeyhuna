package az.atlacademy.springjpaexample.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="name",nullable = false)
    private  String name;
    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "age",nullable = false)
    private int age ;

}
