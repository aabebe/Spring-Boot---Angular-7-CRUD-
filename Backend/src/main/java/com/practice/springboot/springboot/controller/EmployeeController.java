package com.practice.springboot.springboot.controller;

import com.practice.springboot.springboot.domain.Employee;
import com.practice.springboot.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value ="id") Long employeeId){
        return null;

    }
}
