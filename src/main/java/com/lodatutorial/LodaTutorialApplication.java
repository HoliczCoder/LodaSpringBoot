package com.lodatutorial;

import com.lodatutorial.model.Employee;
import com.lodatutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LodaTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(LodaTutorialApplication.class, args);
    }

    @Autowired
    EmployeeRepository employeeRepository;


//    @Override
//    public void run(String... args) throws Exception {
//        Employee employeeA = new Employee();
//        employeeA.setFirstName("Minh");
//        employeeA.setLastName("Tran Cong");
//        employeeA.setEmailId("minhtranconglis@gmail.com");
//        employeeRepository.save(employeeA);
//        Employee employeeB = new Employee();
//        employeeB.setFirstName("Duc");
//        employeeB.setLastName("Tran Cong");
//        employeeB.setEmailId("ductrancong@gmail.com");
//        employeeRepository.save(employeeB);
//    }
}
