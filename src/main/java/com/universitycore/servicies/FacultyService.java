package com.universitycore.servicies;

import com.universitycore.models.Faculty;
import com.universitycore.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class FacultyService{
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }

    public Optional<Faculty> findById(Integer id){
        return facultyRepository.findById(id);
    }

    public Optional<Faculty> findByName(String name){
        return facultyRepository.findByName(name);
    }

    @Transactional
    public void save(Faculty newFaculty){
        facultyRepository.save(newFaculty);
    }

    @Transactional
    public void update(Faculty updatedFaculty){
        facultyRepository.save(updatedFaculty);
    }

    @Transactional
    public void delete(Integer id){
        facultyRepository.deleteById(id);
    }

}
