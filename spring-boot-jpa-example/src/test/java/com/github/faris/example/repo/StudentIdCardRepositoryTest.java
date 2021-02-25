package com.github.faris.example.repo;

import com.github.faris.example.entity.Student;
import com.github.faris.example.entity.StudentIdCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StudentIdCardRepositoryTest extends BasedRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentIdCardRepository studentIdCardRepository;

    private String cardNumber;

    private Long studentIdCardId;

    private Long studentId;

    @BeforeEach
    public void saveTest() {
        Student student = studentRepository.save(initStudent());

        studentId = student.getId();
        studentIdCardId = student.getStudentIdCard().getId();
        cardNumber = student.getStudentIdCard().getCardNumber();
    }

    @Test
    public void findByIdTest() {
        Optional<StudentIdCard> card = studentIdCardRepository.findById(studentIdCardId);
        assertTrue(card.isPresent());
        assertEquals(cardNumber, card.get().getCardNumber());
    }

    @Test
    public void findByCardNumber() {
        Optional<StudentIdCard> card = studentIdCardRepository.findByCardNumber(cardNumber);
        assertTrue(card.isPresent());
        assertEquals(studentIdCardId, card.get().getId());
    }

    @Test
    public void findByStudentId() {
        Optional<StudentIdCard> card = studentIdCardRepository.findByStudentId(studentId);
        assertTrue(card.isPresent());
        assertEquals(studentIdCardId, card.get().getId());
    }
}
