package com.lodatutorial.controller;


import com.lodatutorial.entity.Attachment;
import com.lodatutorial.model.ResponseData;
import com.lodatutorial.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;

@RequestMapping("api/v1")
@RestController
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseData uploadFile (@RequestParam("file")MultipartFile file) throws Exception {
        Attachment attachment = null;
        String downloadURl = "";
        attachment = attachmentService.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(attachment.getId()).toUriString();
        return new ResponseData(attachment.getFileName(), downloadURl, file.getContentType(), file.getSize());
    };
    @GetMapping("/download/{fileId}")
    public ResponseEntity <ByteArrayResource> downloadFile ( @PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType())).header(HttpHeaders.CONTENT_DISPOSITION,"vkl lang nhang vl").body(new ByteArrayResource(attachment.getData()));
    };

}
