package com.example.generatefile.controller;

import com.example.generatefile.model.Employee;
import com.example.generatefile.repository.EmployeeRepository;
import com.example.generatefile.service.DatabasePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class PDFExportController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/openpdf/employees", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport()  throws IOException {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();

        ByteArrayInputStream bis = DatabasePDFService.employeePDFReport(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=employees.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
