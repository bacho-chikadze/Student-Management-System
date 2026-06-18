package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void save() {
        // 1. Mock მონაცემების მომზადება
        Student student = new Student();
        student.setName("Bachex");

        when(repository.save(student)).thenReturn(student);

        // 2. სერვისის მეთოდის გამოძახება
        Student savedStudent = studentService.save(student);

        // 3. შედეგის შემოწმება
        assertNotNull(savedStudent);
        assertEquals("Bachex", savedStudent.getName());
        verify(repository, times(1)).save(student);
    }

    @Test
    void findAll() {
        // 1. Mock მონაცემების მომზადება
        Student s1 = new Student();
        Student s2 = new Student();

        when(repository.findAll()).thenReturn(Arrays.asList(s1, s2));

        // 2. მეთოდის გამოძახება
        List<Student> students = studentService.findAll();

        // 3. შემოწმება
        assertNotNull(students);
        assertEquals(2, students.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void delete() {
        Long studentId = 1L;
        doNothing().when(repository).deleteById(studentId);

        // მეთოდის გამოძახება
        studentService.delete(studentId);

        // შემოწმება
        verify(repository, times(1)).deleteById(studentId);
    }
}