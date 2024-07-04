package com.example.generatefile.controller;

import com.example.generatefile.model.Employee;
import com.example.generatefile.repository.EmployeeRepository;
import com.example.generatefile.service.DatabaseExcelService;
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
public class ExcelExportController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/openexcel/employees")
    private ResponseEntity<InputStreamResource> download() throws IOException {
        String fileName ="employeesExcelReport.xlsx";
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        ByteArrayInputStream bis = DatabaseExcelService.employeeExelReport(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + fileName);

        return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(new InputStreamResource(bis));
    }
}
