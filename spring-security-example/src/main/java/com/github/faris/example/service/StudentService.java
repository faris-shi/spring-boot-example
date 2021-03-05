package com.github.faris.example.service;

import com.github.faris.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author faris
 */
@Service
public class StudentService {

    private static final List<Student> STUDENTS = new ArrayList<>(List.of(
            new Student(1L, "Jane"),
            new Student(2L, "Smith"),
            new Student(3L, "John")
    ));

    public Optional<Student> getStudentById(Long id) {
        return STUDENTS.stream().filter(student -> student.getId().equals(id)).findAny();
    }
}
