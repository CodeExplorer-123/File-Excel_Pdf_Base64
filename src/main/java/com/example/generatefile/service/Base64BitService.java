package com.example.generatefile.service;

import com.example.generatefile.model.FileEntity;
import com.example.generatefile.repository.Base64BitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Service
public class Base64BitService {

     @Autowired
     private Base64BitRepository base64BitRepository;

     public String uploadFile(MultipartFile file){
          try{
               String base64Encoded = Base64.getEncoder().encodeToString(file.getBytes());


               FileEntity fileEntity = new FileEntity();

               fileEntity.setFileName(file.getOriginalFilename());
               fileEntity.setBase64Data(base64Encoded);

               base64BitRepository.save(fileEntity);

               return "File uploaded successfully!";

          }catch (Exception e){
               return "Failed to upload file: " + e.getMessage();
          }
     }

     public byte[] downloadFile(String fileName){
          FileEntity fileEntity = base64BitRepository.findByFileName(fileName);
          if (fileEntity == null) {
               throw new RuntimeException("File not found with filename: " + fileName);
          }
          return Base64.getDecoder().decode(fileEntity.getBase64Data());
     }
}
