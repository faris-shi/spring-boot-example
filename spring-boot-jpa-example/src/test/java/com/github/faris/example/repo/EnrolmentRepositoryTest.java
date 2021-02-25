package com.github.faris.example.repo;

import com.github.faris.example.entity.Enrolment;
import com.github.faris.example.entity.EnrolmentId;
import com.github.faris.example.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnrolmentRepositoryTest extends BasedRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrolmentRepository enrolmentRepository;

    private final EnrolmentId id = new EnrolmentId(1L, 1L);

    @BeforeEach
    public void setup() {
        Student student = initStudent();
        student.getEnrolments().add(
                new Enrolment(
                        id,
                        initCourse(),
                        student
                )
        );
        studentRepository.save(student);
    }

    @Test
    public void findByIdTest() {
        Optional<Enrolment> enrolment = enrolmentRepository.findById(id);
        assertTrue(enrolment.isPresent());
        assertEquals(id, enrolment.get().getEnrolmentId());
    }
}
