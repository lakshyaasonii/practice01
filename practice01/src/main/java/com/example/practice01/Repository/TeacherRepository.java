package com.example.practice01.Repository;

import com.example.practice01.Entity.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, ObjectId> {
    Optional<Teacher> findBySubject(String subject);
    void deleteBySubject(String subject);
}
