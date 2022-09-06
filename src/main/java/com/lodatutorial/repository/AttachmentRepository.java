package com.lodatutorial.repository;

import com.lodatutorial.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository <Attachment, String> {
}
