
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/*
Course table
*/

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // კურსის სახელი
    private String title;

    /*
    ერთ კურსს ბევრი სტუდენტი ჰყავს
    */
    @OneToMany(mappedBy = "course")
    private List<Student> students;
}
