
package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*
@Entity -> database table
*/

@Entity
@Data
public class Student {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ცარიელი არ უნდა იყოს
    @NotBlank(message = "Name is required")
    private String name;

    // email ფორმატი
    @Email(message = "Invalid email")
    private String email;

    /*
    ბევრი სტუდენტი შეიძლება იყოს ერთ კურსზე
    */
    @ManyToOne
    private Course course;
}
