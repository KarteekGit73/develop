package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public String add(@RequestBody Employee emp) {
        service.addEmployee(emp);
        return "Employee Added";
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return service.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PutMapping
    public String update(@RequestBody Employee emp) {
        service.updateEmployee(emp);
        return "Employee Updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee Deleted";
    }
}
