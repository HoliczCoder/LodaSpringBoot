package com.lodatutorial.controller;

import com.lodatutorial.model.Address;
import com.lodatutorial.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<Address> addAddress (@RequestBody Address address){
        return ResponseEntity.ok(addressRepository.save(address));
    }
}
