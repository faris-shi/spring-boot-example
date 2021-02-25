package com.github.faris.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(mappedBy = "studentIdCard")
    private Student student;
}
