package com.example.demo;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee emp);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee emp);
    void deleteEmployee(int id);
}
