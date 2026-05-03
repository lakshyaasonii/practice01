package com.example.practice01.Controller;

import com.example.practice01.Entity.Student;
import com.example.practice01.Entity.Teacher;
import com.example.practice01.Service.StudentService;
import com.example.practice01.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Teacher myEntry){
        try{
            teacherService.saveEntry(myEntry); //agr same subject pehle se hua toh DuplicateKeyException ayega
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Teacher> list = teacherService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{subject}")
    public ResponseEntity<?> findBySubject(@PathVariable String subject){
        Teacher t = teacherService.findBySubject(subject);
       if(t == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       else{
           return new ResponseEntity<>(t,HttpStatus.FOUND);
       }
    }

    @DeleteMapping("/{subject}")
    public ResponseEntity<?> deleteBySubject(@PathVariable String subject){
        Teacher t = teacherService.findBySubject(subject);
        if(t == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            teacherService.deleteBySubject(subject);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
