package com.example.practice01.Controller;

import com.example.practice01.Entity.Student;
import com.example.practice01.Entity.Teacher;
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

    @PostMapping("/{subject}")
    public ResponseEntity<?> saveEntry(@PathVariable String subject, @RequestBody Student myEntry){
        try{
            studentService.saveEntry(myEntry,subject);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Student> list = studentService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<?> findByRollNo(@PathVariable int rollNo){
        Student s = studentService.findByRollNo(rollNo);
        if(s == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(s,HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/{rollNo}/{subject}")
    public ResponseEntity<?> deleteByRollNo(@PathVariable int rollNo, @PathVariable String subject){
       try{
           studentService.deleteByRollNo(rollNo,subject);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}
