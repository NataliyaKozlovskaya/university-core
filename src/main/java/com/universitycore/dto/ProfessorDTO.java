package com.universitycore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private Integer id;
    private Integer facultyId;
    private String fullName;
    private Integer age;
    private String email;
    private Integer workExperience;

}
