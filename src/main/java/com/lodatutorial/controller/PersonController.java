package com.lodatutorial.controller;

import com.lodatutorial.dto.PersonDto;
import com.lodatutorial.model.Address;
import com.lodatutorial.model.Person;
import com.lodatutorial.repository.AddressRepository;
import com.lodatutorial.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson (){
        return ResponseEntity.ok(personRepository.findAll());
    }

    @PutMapping
    public ResponseEntity<Person> changePersonInfo(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    @PutMapping("/{id_person}/address/{id_address}")
    public ResponseEntity<PersonDto> updatePersonAddress(@PathVariable Long id_address, @PathVariable Long id_person) {
        Person person = personRepository.findById(id_person).get();
        Address address = addressRepository.findById(id_address).get();
//        address.setPersons(person);
//        addressRepository.save(address);
//        return ResponseEntity.ok(personRepository.findById(id_person).get());
        person.setAddress(address);
//        address.setPersons(Collections.singleton(person));
//        address.getPersons().add(person);
//        addressRepository.save(address);
        personRepository.save(person);
        return ResponseEntity.ok(new PersonDto(person));
    }


}
