package com.example.practice01.Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_entries")
@Data
public class Student { //POJO of student entries

    @Id
    private ObjectId id;


    private String name;

    @Indexed(unique = true)
    private int rollNo;
}
