package com.practice.springboot.springboot.controller;

import com.practice.springboot.springboot.domain.Employee;
import com.practice.springboot.springboot.exception.ResourceNotFoundException;
import com.practice.springboot.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeService.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not found for this id::" + employeeId));
        return ResponseEntity.ok().body(employee);

    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails)
            throws ResourceNotFoundException {
        Employee employee = employeeService.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(("Employee not found for this id :: " + employeeId)));
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        final Employee updatedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(updatedEmployee);

    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deletedEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeService.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(("Employee not found for this id :: " + employeeId));
        employeeService.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
