package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public void addEmployee(Employee emp) {
        dao.save(emp);
    }

    public Employee getEmployee(int id) {
        return dao.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    public void updateEmployee(Employee emp) {
        dao.update(emp);
    }

    public void deleteEmployee(int id) {
        dao.delete(id);
    }
}
