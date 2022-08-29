package com.lodatutorial.controller;

import com.lodatutorial.exception.ResourceNotFoundException;
import com.lodatutorial.model.Employee;
import com.lodatutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findById(id).get());
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist" + id));
//       ResponseEntity.BodyBuilder bodyBuilder =  ResponseEntity.status(500);
        return ResponseEntity.ok(employee);
//        return ResponseEntity.ok(employeeRepository.findById(id).get());
    }

    @PutMapping(value = "/update_employee")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            this.employeeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no data found");
    }

}
