package com.github.faris.example.controller;

import com.github.faris.example.model.Student;
import com.github.faris.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('STUDENT_READ')")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id).
                orElseThrow(() -> new IllegalStateException("Student with id:" + id + " not exist"));
        return ResponseEntity.ok(student);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('STUDENT_READ')")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('STUDENT_WRITE')")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyAuthority('STUDENT_WRITE')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('STUDENT_WRITE')")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return ResponseEntity.noContent().build();
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
