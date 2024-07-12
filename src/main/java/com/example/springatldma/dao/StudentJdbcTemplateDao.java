package com.example.springatldma.dao;

import com.example.springatldma.model.Student;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentJdbcTemplateDao implements StudentDao<Student> {

    private static final String FIND_STUDENT_BY_ID = "SELECT*FROM students WHERE id=?;";

    private JdbcTemplate jdbcTemplate;

    public StudentJdbcTemplateDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(FIND_STUDENT_BY_ID, new Object[]{id}, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            student.setAge(rs.getInt("age"));

            return student;
        }));
    }

    @Override
    public List<Student> getAllStudents() {
        return jdbcTemplate.queryForObject(FIND_STUDENT_BY_ID, (rs, rowNum) -> {
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setAge(rs.getInt("age"));
                students.add(student);
            }
            return students;

        });
    }


}
