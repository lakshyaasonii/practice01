package com.example.practice01.Service;

import com.example.practice01.Entity.Student;
import com.example.practice01.Repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveEntry(Student myEntry){
        studentRepository.save(myEntry);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findByRollNo(int rollNo){
        return studentRepository.findByRollNo(rollNo);
    }
    public void deleteById(ObjectId id){
        studentRepository.deleteById(id);
   }

    public void deleteByRollNo(int rollNo){
        studentRepository.deleteByRollNo(rollNo);
    }
}
