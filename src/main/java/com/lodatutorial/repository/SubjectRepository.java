package com.lodatutorial.repository;

import com.lodatutorial.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository <Subject, Long> {
}
