package com.lodatutorial.repository;

import com.lodatutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
