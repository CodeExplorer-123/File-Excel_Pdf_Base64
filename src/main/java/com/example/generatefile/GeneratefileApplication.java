package com.example.generatefile;

import com.example.generatefile.model.Employee;
import com.example.generatefile.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GeneratefileApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(GeneratefileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		if (employeeRepository.count() == 0) {
//			// save a list of Employees
//			employeeRepository.saveAll(Arrays.asList(
//					new Employee(10,"Donald", "Grant", "Accounts", "650.507.9833"),
//					new Employee(15,"Douglas", "Nolan", "Admin", "650.507.9844"),
//					new Employee(20,"Jennifer", "Whalen", "Finance", "515.123.4444"),
//					new Employee(25,"Michael", "Hartstein", "Security", "515.123.5555"),
//					new Employee(30,"Pat", "Fay", "Technology", "603.123.6666"),
//					new Employee(35,"Jack", "Dawson", "Infra", "550.907.9933"),
//					new Employee(40,"Susan", "Mavrik", "Science", "515.123.7777")));
//		}

	}
}
