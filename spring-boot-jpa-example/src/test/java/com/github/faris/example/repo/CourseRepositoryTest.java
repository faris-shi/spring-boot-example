package com.github.faris.example.repo;

import com.github.faris.example.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseRepositoryTest extends BasedRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private String courseNo;

    private Long id;

    @BeforeEach
    public void setup() {
        Course course = initCourse();
        courseRepository.save(course);
        id = course.getId();
        courseNo = course.getCourseNo();
    }

    @Test
    public void findByIdTest() {
        Optional<Course> course = courseRepository.findById(id);
        assertTrue(course.isPresent());
        assertEquals(courseNo, course.get().getCourseNo());
    }

    @Test
    public void findByCourseNoTest() {
        Optional<Course> course = courseRepository.findByCourseNo(courseNo);
        assertTrue(course.isPresent());
        assertEquals(id, course.get().getId());
    }
}
