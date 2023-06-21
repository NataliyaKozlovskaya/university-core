package com.universitycore.servicies;

import com.universitycore.models.Professor;
import com.universitycore.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Integer id){
        return professorRepository.findById(id);
    }

    public Optional<Professor> findByFullName(String fullName){
        return professorRepository.findByFullName(fullName);
    }

    @Transactional
    public void save(Professor newProfessor){
        professorRepository.save(newProfessor);
    }

    @Transactional
    public void update(Professor updatedProfessor){
        professorRepository.save(updatedProfessor);
    }

    @Transactional
    public void delete(Integer id){
        professorRepository.deleteById(id);
    }

}
