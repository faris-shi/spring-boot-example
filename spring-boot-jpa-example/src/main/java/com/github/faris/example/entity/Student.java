package com.github.faris.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_uk",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "student_student_id_card_id_uk",
                        columnNames = "student_id_card_id"
                )
        }
)
public class Student implements Serializable {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "student_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;


    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id_card_id",
            foreignKey = @ForeignKey(name = "student_student_id_card_id_fk"),
            nullable = false,
            updatable = false
    )
    private StudentIdCard studentIdCard;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Enrolment> enrolments = new ArrayList<>();

    @OneToMany
    private List<Hobby> hobbys;
}
