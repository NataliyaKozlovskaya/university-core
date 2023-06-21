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
@Table(name="professor")
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;

    @Column(name="full_name")
    private String fullName;

    @Column(name="age")
    private Integer age;

    @Column(name="email")
    private String email;

    @Column(name="work_experience")
    private Integer workExperience;

}
