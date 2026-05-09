
package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController -> JSON აბრუნებს
*/

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService service;

    // GET request
    @GetMapping
    public List<Student> all(){
        return service.findAll();
    }

    // POST request
    @PostMapping
    public Student create(@RequestBody Student student){
        return service.save(student);
    }
}
