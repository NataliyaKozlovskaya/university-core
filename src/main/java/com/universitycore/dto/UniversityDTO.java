package com.universitycore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDTO {

    private Integer id;
    private String name;
    private String address;
    private String rector;
    private Integer yearOfFoundation;

}
