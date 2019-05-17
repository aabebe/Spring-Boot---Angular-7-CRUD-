package com.practice.springboot.springboot.service;

import com.practice.springboot.springboot.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);

}
