package com.lodatutorial.controller;

import com.lodatutorial.exception.ResourceNotFoundException;
import com.lodatutorial.model.Student;
import com.lodatutorial.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(student));
    }

    ;

    @GetMapping
    public ResponseEntity<List<Student>> showAllStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id) {
        Optional student = studentRepository.findById(id);
        if (student.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(student);
        };
        return ResponseEntity.ok("khong co du lieu");
    }

    @PutMapping
    public ResponseEntity<Student> changeStudentInfo(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        Optional student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("okie");
        }
        return ResponseEntity.ok("khong tim thay student");
    }


}
