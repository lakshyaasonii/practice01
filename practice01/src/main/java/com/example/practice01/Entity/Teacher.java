package com.example.practice01.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "teacher_entries")
@Data
public class Teacher { //POJO of teacher entries

    @Id
    private ObjectId id;


    private String name;

    @Indexed(unique = true)
    private String subject;

    @DBRef
    List<Student> student_list = new ArrayList<>();
}
