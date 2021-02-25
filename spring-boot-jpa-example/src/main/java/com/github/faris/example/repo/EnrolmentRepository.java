package com.github.faris.example.repo;

import com.github.faris.example.entity.Enrolment;
import com.github.faris.example.entity.EnrolmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<Enrolment, EnrolmentId> {
}
