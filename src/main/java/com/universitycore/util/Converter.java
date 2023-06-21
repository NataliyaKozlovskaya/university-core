package com.universitycore.util;

import com.universitycore.dto.FacultyDTO;
import com.universitycore.dto.ProfessorDTO;
import com.universitycore.dto.StudentDTO;
import com.universitycore.dto.UniversityDTO;
import com.universitycore.models.Faculty;
import com.universitycore.models.Professor;
import com.universitycore.models.Student;
import com.universitycore.models.University;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    private final ModelMapper modelMapper;

    @Autowired
    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public University convertToUniversity(UniversityDTO universityDTO){
        return modelMapper.map(universityDTO, University.class);
    }
    public UniversityDTO convertToUniversityDTO(University university){
        return modelMapper.map(university, UniversityDTO.class);
    }


    public Faculty convertToFaculty(FacultyDTO facultyDTO){
        return modelMapper.map(facultyDTO, Faculty.class);
    }
    public FacultyDTO convertToFacultyDTO(Faculty faculty){
        return modelMapper.map(faculty, FacultyDTO.class);
    }


    public Student convertToStudent(StudentDTO studentDTO){
        return modelMapper.map(studentDTO, Student.class);
    }
    public StudentDTO convertToStudentDTO(Student student){
        return modelMapper.map(student, StudentDTO.class);
    }


    public Professor convertToProfessor(ProfessorDTO professorDTO){
        return modelMapper.map(professorDTO, Professor.class);
    }
    public ProfessorDTO convertToProfessorDTO(Professor professor){
        return modelMapper.map(professor, ProfessorDTO.class);
    }

}
