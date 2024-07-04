package com.example.generatefile.controller;

import com.example.generatefile.service.Base64BitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/file")
public class Base64BitController {

    @Autowired
    private Base64BitService base64BitService;

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        return base64BitService.uploadFile(file);
    }


    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> handleFileDownload(@RequestParam String fileName){
        HttpHeaders headers = new HttpHeaders();
        byte[] bytes = base64BitService.downloadFile(fileName);
        return ResponseEntity.ok().contentType(MediaType.valueOf("application/pdf")).body(bytes);
    }
}
