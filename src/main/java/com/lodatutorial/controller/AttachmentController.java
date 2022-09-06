package com.lodatutorial.controller;


import com.lodatutorial.entity.Attachment;
import com.lodatutorial.model.ResponseData;
import com.lodatutorial.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping("api/v1/upload")
@RestController
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping()
    public ResponseData uploadFile (@RequestParam("file")MultipartFile file) throws Exception {
        Attachment attachment = null;
        String downloadURl = "";
        attachment = attachmentService.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/dowload").path(attachment.getId()).toUriString();
        return new ResponseData(attachment.getFileName(), downloadURl, file.getContentType(), file.getSize());
    };

}
