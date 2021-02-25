package com.github.faris.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Course")
@Table(
        name = "course",
        uniqueConstraints = @UniqueConstraint(
                name = "course_course_no_uk",
                columnNames = "course_no"
        )
)
public class Course implements Serializable {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name="course_no", updatable = false, nullable = false)
    private String courseNo;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Enrolment> enrolments = new ArrayList<>();
}