package com.universitycore.servicies;

import com.universitycore.models.University;
import com.universitycore.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UniversityService {
    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> findAll(){
        return universityRepository.findAll();
    }

    public Optional<University> findById(Integer id){
        return universityRepository.findById(id);
    }

    public Optional<University> findByName(String name){
        return universityRepository.findByName(name);
    }

    @Transactional
    public void save(University newUniversity){
        universityRepository.save(newUniversity);
    }

    @Transactional
    public void update(University updatedUniversity){
        universityRepository.save(updatedUniversity);
    }

    @Transactional
    public void delete(Integer id){
        universityRepository.deleteById(id);
    }

}
