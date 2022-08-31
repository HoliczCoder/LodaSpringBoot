package com.lodatutorial.controller;

import com.lodatutorial.model.Student;
import com.lodatutorial.model.Subject;
import com.lodatutorial.repository.StudentRepository;
import com.lodatutorial.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {


    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Subject> addNewSubject(@RequestBody @Valid Subject subject) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectRepository.save(subject));
    }

    @GetMapping
    public ResponseEntity<List<Subject>> showAllSubject() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findSubjectById(@PathVariable Long id) {
        Optional subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(subject);
        }
        ;
        return ResponseEntity.ok("khong co du lieu");
    }

    @PutMapping
    public ResponseEntity<Subject> changeSubjectInfo(@RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectRepository.save(subject));
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public ResponseEntity<Subject> enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        Subject subject = subjectRepository.findById(subjectId).get();
        subject.addEnrolledStudent(student);
        return ResponseEntity.ok(subjectRepository.save(subject));
    }
    ;

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubject(@PathVariable Long id) {
        Optional subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            subjectRepository.deleteById(id);
            return ResponseEntity.ok("okie");
        }
        return ResponseEntity.ok("khong tim thay subject");
    }

}
