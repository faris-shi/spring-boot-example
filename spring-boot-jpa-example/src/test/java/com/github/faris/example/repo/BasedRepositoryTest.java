package com.github.faris.example.repo;

import com.github.faris.example.entity.Course;
import com.github.faris.example.entity.Student;
import com.github.faris.example.entity.StudentIdCard;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.UUID;

@DataJpaTest
@Rollback
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BasedRepositoryTest {

    protected Student initStudent() {
        Student student = new Student();
        student.setAge(10);
        student.setEmail("faris.shi@gmail.com");
        student.setFirstName("Faris");
        student.setLastName("Shi");
        student.setStudentIdCard(initStudentIdCard());
        return student;
    }

    protected StudentIdCard initStudentIdCard() {
        StudentIdCard idCard = new StudentIdCard();
        idCard.setPhoto("photo.png");
        idCard.setCardNumber(UUID.randomUUID().toString());
        return idCard;
    }

    protected Course initCourse() {
        Course course = new Course();
        course.setCourseNo(UUID.randomUUID().toString());
        course.setName("Java");
        return course;
    }
}
