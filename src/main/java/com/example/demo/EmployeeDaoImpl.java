package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Employee emp) {
        jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES (?,?,?)",
                emp.getId(), emp.getName(), emp.getSalary());
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM EMPLOYEE WHERE ID=?",
                (rs, rowNum) -> new Employee(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getDouble("SALARY")
                ), id);
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM EMPLOYEE",
                (rs, rowNum) -> new Employee(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getDouble("SALARY")
                ));
    }

    public void update(Employee emp) {
        jdbcTemplate.update(
                "UPDATE EMPLOYEE SET NAME=?, SALARY=? WHERE ID=?",
                emp.getName(), emp.getSalary(), emp.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE ID=?", id);
    }
}
