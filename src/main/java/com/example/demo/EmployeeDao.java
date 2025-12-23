package com.example.demo;

import java.util.List;

public interface EmployeeDao {
    void save(Employee emp);
    Employee findById(int id);
    List<Employee> findAll();
    void update(Employee emp);
    void delete(int id);
}
