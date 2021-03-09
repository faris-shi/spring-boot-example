package com.github.faris.springsecurityformauthexmaple.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('student.read')")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok("all student");
    }
}
