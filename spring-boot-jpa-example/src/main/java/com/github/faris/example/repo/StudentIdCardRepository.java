package com.github.faris.example.repo;

import com.github.faris.example.entity.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {

    Optional<StudentIdCard> findByCardNumber(String cardNumber);

    Optional<StudentIdCard> findByStudentId(Long studentId);
}
