package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    // Constructor Injection (recommended)
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Employees module health check
    @GetMapping("/health")
    public String health() {
        return "Employees service is up and running!";
    }

    // Create employee
    @PostMapping
    public String add(@RequestBody Employee emp) {
        service.addEmployee(emp);
        return "Employee Added";
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return service.getEmployee(id);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    // Update employee
    @PutMapping
    public String update(@RequestBody Employee emp) {
        service.updateEmployee(emp);
        return "Employee Updated";
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee Deleted";
    }
}
