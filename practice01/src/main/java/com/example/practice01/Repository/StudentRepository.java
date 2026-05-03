package com.example.practice01.Repository;

import com.example.practice01.Entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {
    Student findByRollNo(int rollNo);
    void deleteByRollNo(int rollNo);
}
