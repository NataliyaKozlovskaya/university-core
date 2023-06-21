package com.universitycore.controllers;

import com.universitycore.dto.StudentDTO;
import com.universitycore.models.Student;
import com.universitycore.servicies.StudentService;
import com.universitycore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final Converter converter;

    @Autowired
    public StudentController(StudentService studentService, Converter converter) {
        this.studentService = studentService;
        this.converter = converter;
    }

    @GetMapping
    public List<StudentDTO> findAll(){
        return studentService.findAll().stream().map(converter::convertToStudentDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Integer id){
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()){
            StudentDTO studentDTO = converter.convertToStudentDTO(student.get());
            return ResponseEntity.ok(studentDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/fullName/{fullName}")
    public ResponseEntity<StudentDTO> findByFullName(@PathVariable("fullName") String fullName){
        Optional<Student> student = studentService.findByFullName(fullName);
        if (student.isPresent()){
            StudentDTO studentDTO = converter.convertToStudentDTO(student.get());
            return ResponseEntity.ok(studentDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public void create(@RequestBody StudentDTO newStudentDTO){
        studentService.save(converter.convertToStudent(newStudentDTO));
    }

    @PatchMapping
    public void update(@RequestBody StudentDTO updatedStudentDTO){
        studentService.update(converter.convertToStudent(updatedStudentDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        studentService.delete(id);
    }

}