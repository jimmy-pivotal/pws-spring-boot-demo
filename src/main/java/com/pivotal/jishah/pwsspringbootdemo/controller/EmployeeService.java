package com.pivotal.jishah.pwsspringbootdemo.controller;

import com.pivotal.jishah.pwsspringbootdemo.dao.EmployeeDao;
import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee/{employeeId}")
    public Optional<Employee> findEmployeeById(@PathVariable Integer employeeId) {
        return employeeDao.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
