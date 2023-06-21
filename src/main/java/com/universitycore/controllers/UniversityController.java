package com.universitycore.controllers;

import com.universitycore.dto.UniversityDTO;
import com.universitycore.models.University;

import com.universitycore.servicies.UniversityService;
import com.universitycore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;
    private final Converter converter;

    @Autowired
    public UniversityController(UniversityService universityService, Converter converter) {
        this.universityService = universityService;
        this.converter = converter;
    }

    @GetMapping
    public List<UniversityDTO> findAll() {
        return universityService.findAll().stream().map(converter::convertToUniversityDTO).collect(Collectors.toList());
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<UniversityDTO> findById(@PathVariable("id") Integer id) {
        Optional<University> university = universityService.findById(id);
        if (university.isPresent()) {
            UniversityDTO universityDTO = converter.convertToUniversityDTO(university.get());
            return ResponseEntity.ok(universityDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<UniversityDTO> findByName(@PathVariable("name") String name) {
        Optional<University> university = universityService.findByName(name);
        if (university.isPresent()) {
            UniversityDTO universityDTO = converter.convertToUniversityDTO(university.get());
            return ResponseEntity.ok(universityDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public void create(@RequestBody UniversityDTO newUniversityDTO) {
        universityService.save(converter.convertToUniversity(newUniversityDTO));
    }

    @PatchMapping
    public void update(@RequestBody UniversityDTO updatedUniversityDTO) {
        universityService.update(converter.convertToUniversity(updatedUniversityDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        universityService.delete(id);
    }

}








