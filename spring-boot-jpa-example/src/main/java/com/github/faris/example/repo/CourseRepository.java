package com.github.faris.example.repo;

import com.github.faris.example.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseNo(String courseNo);
}
