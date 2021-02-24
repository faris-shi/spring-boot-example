package com.github.faris.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EnrolmentId implements Serializable {

    @Column(name = "student_id", updatable = false, nullable = false)
    private Long studentId;

    @Column(name = "course_id", updatable = false, nullable = false)
    private Long courseId;
}
