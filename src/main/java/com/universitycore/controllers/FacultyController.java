package com.universitycore.controllers;

import com.universitycore.dto.FacultyDTO;
import com.universitycore.models.Faculty;
import com.universitycore.servicies.FacultyService;
import com.universitycore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    private final Converter converter;

    @Autowired
    public FacultyController(FacultyService facultyService, Converter converter) {
        this.facultyService = facultyService;
        this.converter = converter;
    }

    @GetMapping
    public List<FacultyDTO> findAll(){
        return facultyService.findAll().stream().map(converter::convertToFacultyDTO).collect(Collectors.toList());
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<FacultyDTO> findById(@PathVariable("id") Integer id){
        Optional<Faculty> faculty = facultyService.findById(id);
        if (faculty.isPresent()){
            FacultyDTO facultyDTO = converter.convertToFacultyDTO(faculty.get());
            return ResponseEntity.ok(facultyDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<FacultyDTO> findByName(@PathVariable("name") String name){
        Optional<Faculty> faculty = facultyService.findByName(name);
        if (faculty.isPresent()){
            FacultyDTO facultyDTO = converter.convertToFacultyDTO(faculty.get());
            return ResponseEntity.ok(facultyDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public void create(@RequestBody FacultyDTO newFacultyDTO){
        facultyService.save(converter.convertToFaculty(newFacultyDTO));
    }

    @PatchMapping
    public void update(@RequestBody FacultyDTO updatedFacultyDTO){
        facultyService.update(converter.convertToFaculty(updatedFacultyDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        facultyService.delete(id);
    }

}
