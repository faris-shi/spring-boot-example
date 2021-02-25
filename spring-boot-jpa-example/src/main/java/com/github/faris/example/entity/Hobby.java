package com.github.faris.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hobby")
public class Hobby implements Serializable{

    @Id
    @SequenceGenerator(name = "hobby_sequence", sequenceName = "hobby_sequence")
    @GeneratedValue(generator = "hobby_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
