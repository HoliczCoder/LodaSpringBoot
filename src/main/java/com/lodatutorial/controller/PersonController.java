package com.lodatutorial.controller;

import com.lodatutorial.model.Person;
import com.lodatutorial.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @PutMapping
    public ResponseEntity<Person> changePersonInfo(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @PutMapping ("/{id_person}/address/{id_address}")
    public ResponseEntity<Person> updatePersonAddress ( @PathVariable Long id_address, @PathVariable Long id_person ){

    }


}
