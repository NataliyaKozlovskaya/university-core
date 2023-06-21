package com.universitycore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {

    private Integer id;
    private Integer universityId;
    private String name;
    private String dean;
    private Integer rating;

}
