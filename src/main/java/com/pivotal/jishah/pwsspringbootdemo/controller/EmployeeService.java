package com.pivotal.jishah.pwsspringbootdemo.controller;

import com.pivotal.jishah.pwsspringbootdemo.dao.EmployeeDao;
import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import com.pivotal.jishah.pwsspringbootdemo.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeService {

    @Value("${name}")
    private String propertyName;

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee/{employeeId}")
    public Optional<Employee> findEmployeeById(@PathVariable Integer employeeId) {
        return employeeDao.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        return employees;
    }

    @GetMapping("/name")
    public String getName() {
        return "Hello";
    }

    @GetMapping("/propertyName")
    public String getPropertyName() {
        return propertyName;
    }

    @PostMapping("/employees")
    public Employee createEmployee(EmployeeDto employee) {
        return employeeDao.save(employee);
    }
}
