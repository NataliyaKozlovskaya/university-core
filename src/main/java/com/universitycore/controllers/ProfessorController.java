package com.universitycore.controllers;

import com.universitycore.dto.ProfessorDTO;
import com.universitycore.models.Professor;
import com.universitycore.servicies.ProfessorService;
import com.universitycore.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;
    private final Converter converter;

    @Autowired
    public ProfessorController(ProfessorService professorService, Converter converter) {
        this.professorService = professorService;
        this.converter = converter;
    }


    @GetMapping
    public List<ProfessorDTO> findAll(){
        return professorService.findAll().stream().map(converter::convertToProfessorDTO).collect(Collectors.toList());
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<ProfessorDTO> findById(@PathVariable("id") Integer id){
        Optional<Professor> professor = professorService.findById(id);
        if (professor.isPresent()){
            ProfessorDTO professorDTO = converter.convertToProfessorDTO(professor.get());
            return ResponseEntity.ok(professorDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/fullName/{fullName}")
    public ResponseEntity<ProfessorDTO> findByFullName(@PathVariable("fullName") String fullName){
        Optional<Professor> professor = professorService.findByFullName(fullName);
        if (professor.isPresent()){
            ProfessorDTO professorDTO = converter.convertToProfessorDTO(professor.get());
            return ResponseEntity.ok(professorDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public void create(@RequestBody ProfessorDTO newProfessorDTO){
        professorService.save(converter.convertToProfessor(newProfessorDTO));
    }

    @PatchMapping
    public void update(@RequestBody ProfessorDTO updatedProfessorDTO){
        professorService.update(converter.convertToProfessor(updatedProfessorDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        professorService.delete(id);
    }

}
