package com.example.generatefile.service;

import com.example.generatefile.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class DatabaseExcelService {

    public static String HEADER[] = {"id", "firstname", "lastname", "department","phonenumber"};
    public static String SHEET_NAME = "sheetForEmployeeData";

    public static ByteArrayInputStream employeeExelReport(List<Employee> employeeList) throws IOException {
        Workbook workbook  = new XSSFWorkbook();

        ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
        try {
            Sheet sheet = workbook.createSheet(SHEET_NAME);
            Row row = sheet.createRow(0);

            for (int i  =0; i< HEADER.length;i++){

                Cell cell = row.createCell(i);
                cell.setCellValue(HEADER[i]);
            }

            int rowIndex = 1;
            for (Employee e : employeeList){
                Row row1 = sheet.createRow(rowIndex);
                rowIndex++;
                row1.createCell(0).setCellValue(e.getId());
                row1.createCell(1).setCellValue(e.getFirstName());
                row1.createCell(2).setCellValue(e.getLastName());
                row1.createCell(3).setCellValue(e.getDepartment());
                row1.createCell(4).setCellValue(e.getPhoneNumber());
            }

            workbook.write(byteArrayOutputStream);
            return  new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            workbook.close();
            byteArrayOutputStream.close();
        }
    }
}
