package com.example.generatefile.repository;

import com.example.generatefile.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Base64BitRepository extends JpaRepository<FileEntity,Long> {
    FileEntity findByFileName(String filename);
}
