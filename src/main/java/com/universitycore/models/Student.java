package com.universitycore.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;

    @Column(name="year_of_study")
    private Integer yearOfStudy;

    @Column(name="average_mark")
    private Double averageMark;

}
