package com.example.practice01.Controller;

import com.example.practice01.Entity.Student;
import com.example.practice01.Service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Student myEntry){
        try{
            studentService.saveEntry(myEntry); //agr same roll no pehle se hua toh DuplicateKeyException ayega
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Student> list = studentService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<?> findByRollNo(@PathVariable int rollNo){
        Optional<Student> s = studentService.findByRollNo(rollNo);
        if(s.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(s,HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<?> deleteByRollNo(@PathVariable int rollNo){
        Optional<Student> s = studentService.findByRollNo(rollNo);
        if(s.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            studentService.deleteByRollNo(rollNo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
