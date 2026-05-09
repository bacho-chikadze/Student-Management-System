
package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@Service -> ბიზნეს ლოგიკა
*/

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository repository;

    // სტუდენტის შენახვა
    public Student save(Student student){

        // info level log
        log.info("Student saved");

        return repository.save(student);
    }

    // ყველა სტუდენტის წამოღება
    public List<Student> findAll(){
        return repository.findAll();
    }

    // წაშლა
    public void delete(Long id){

        // warn level log
        log.warn("Student deleted");

        repository.deleteById(id);
    }
}
