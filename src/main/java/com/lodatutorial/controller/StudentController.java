package com.lodatutorial.controller;

import com.lodatutorial.model.Student;
import com.lodatutorial.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @PostMapping
    public ResponseEntity<Student> addNewStudent (@RequestBody Student student){
        return  ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(student));
    };






}
