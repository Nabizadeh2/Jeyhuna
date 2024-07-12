package com.example.springatldma.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


}
