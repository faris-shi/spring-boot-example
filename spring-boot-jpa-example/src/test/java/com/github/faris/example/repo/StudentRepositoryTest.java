package com.github.faris.example.repo;

import com.github.faris.example.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentRepositoryTest extends BasedRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    private Long studentId;

    private String cardNumber;

    private Long studentIdCardId;

    private String email;

    @BeforeEach
    public void saveTest() {

        Student student = studentRepository.save(initStudent());
        studentId = student.getId();
        email = student.getEmail();

        studentIdCardId = student.getStudentIdCard().getId();
        cardNumber = student.getStudentIdCard().getCardNumber();
    }

    @Test
    public void findAllStudentTest() {
        List<Student> list = studentRepository.findAll();
        assertEquals(1, list.size());

        Student student = list.get(0);
        assertEquals(studentId, student.getId());

        assertEquals(studentIdCardId, student.getStudentIdCard().getId());
        assertEquals(cardNumber, student.getStudentIdCard().getCardNumber());
    }

    @Test
    public void findOneTest() {
        Optional<Student> student = studentRepository.findById(studentId);
        assertTrue(student.isPresent());
        assertEquals(studentId, student.get().getId());
    }

    @Test
    public void findByEmailTest() {
        Optional<Student> student = studentRepository.findByEmail(email);
        assertTrue(student.isPresent());
        assertEquals(studentId, student.get().getId());
    }

    @Test
    public void findByCardNumberTest() {
        Optional<Student> student = studentRepository.findByStudentIdCardCardNumber(cardNumber);
        assertTrue(student.isPresent());
        assertEquals(studentId, student.get().getId());
    }
}
