package com.example.practice01.Service;

import com.example.practice01.Entity.Student;
import com.example.practice01.Entity.Teacher;
import com.example.practice01.Repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherService teacherService;

    @Transactional
    public void saveEntry(Student myEntry,String subject){
        Teacher t = teacherService.findBySubject(subject);
        if(t == null){
            throw new RuntimeException("This subject is Not found");
        }
        else{
            studentRepository.save(myEntry);
            t.getStudent_list().add(myEntry);
            teacherService.saveEntry(t);
        }
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student findByRollNo(int rollNo){
        return studentRepository.findByRollNo(rollNo);
    }
    public void deleteById(ObjectId id){
        studentRepository.deleteById(id);
   }

   @Transactional
    public void deleteByRollNo(int rollNo, String subject){
        Teacher t = teacherService.findBySubject(subject);
        Student s = studentRepository.findByRollNo(rollNo);
        if(t == null || s == null){
            throw new RuntimeException("This subject or roll number is not found");
        }
        else{
            studentRepository.deleteByRollNo(rollNo);
            t.getStudent_list().removeIf(x -> x.getRollNo() == rollNo);
            teacherService.saveEntry(t);
        }
    }
}
