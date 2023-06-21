package com.universitycore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;
    private String fullName;
    private Integer facultyId;
    private Integer yearOfStudy;
    private Double averageMark;

}
