package com.github.faris.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "student_id_card",
        uniqueConstraints = @UniqueConstraint(
                name = "student_id_card_card_number_uk",
                columnNames = "card_number"
        )
)
public class StudentIdCard implements Serializable {

    @Id
    @SequenceGenerator(name = "student_id_card_sequence", sequenceName = "student_id_card_sequence")
    @GeneratedValue(generator = "student_id_card_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "card_number", updatable = false, nullable = false)
    private String cardNumber;

    @Column(name = "photo", nullable = false)
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(name = "student_id_card_student_id_fk")
    )
    private Student student;
}
