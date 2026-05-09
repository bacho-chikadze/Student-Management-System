
package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Repository გამოიყენება database ოპერაციებისთვის
*/

public interface StudentRepository extends JpaRepository<Student, Long> {

}
