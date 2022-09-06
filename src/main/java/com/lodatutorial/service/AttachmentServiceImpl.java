package com.lodatutorial.service;

import com.lodatutorial.entity.Attachment;
import com.lodatutorial.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (filename.contains("..")){
                throw new Exception("File name contains invalid path sequence");
            }
            Attachment attachment = new Attachment(filename, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch ( Exception e){
            throw new Exception("Could not save File" + filename);
        }
    }
}
