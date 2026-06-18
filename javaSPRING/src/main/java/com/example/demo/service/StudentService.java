
package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "students", allEntries = true)
    // სტუდენტის შენახვა
    public Student save(Student student){

        // info level log
        log.info("Student saved");

        return repository.save(student);
    }

    // ყველა სტუდენტის წამოღება
    @Cacheable(value = "students")
    public List<Student> findAll(){
        log.info("Fetching from database...");
        return repository.findAll();
    }


    // წაშლა
    @CacheEvict(value = "students",allEntries = true)
    public void delete(Long id){

        // warn level log
        log.warn("Student deleted");

        repository.deleteById(id);
    }
}
