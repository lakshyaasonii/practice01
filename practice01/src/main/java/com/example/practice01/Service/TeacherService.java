package com.example.practice01.Service;

import com.example.practice01.Entity.Student;
import com.example.practice01.Entity.Teacher;
import com.example.practice01.Repository.StudentRepository;
import com.example.practice01.Repository.TeacherRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveEntry(Teacher myEntry){
        teacherRepository.save(myEntry);
    }

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public Teacher findBySubject(String subject){
        return teacherRepository.findBySubject(subject);
    }
    public void deleteById(ObjectId id){
        teacherRepository.deleteById(id);
   }

    public void deleteBySubject(String subject){
        teacherRepository.deleteBySubject(subject);
    }
}
