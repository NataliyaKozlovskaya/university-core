package com.universitycore.servicies;

import com.universitycore.models.Student;
import com.universitycore.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Integer id){
        return studentRepository.findById(id);
    }

    public Optional<Student> findByFullName(String fullName){
        return studentRepository.findByFullName(fullName);
    }

    @Transactional
    public void save(Student newStudent){
        studentRepository.save(newStudent);
    }

    @Transactional
    public void update(Student updatedStudent){
        studentRepository.save(updatedStudent);
    }

    @Transactional
    public void delete(Integer id){
        studentRepository.deleteById(id);
    }

}
