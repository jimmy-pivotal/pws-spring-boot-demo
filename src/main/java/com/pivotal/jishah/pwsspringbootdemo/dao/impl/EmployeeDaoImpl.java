package com.pivotal.jishah.pwsspringbootdemo.dao.impl;

import com.pivotal.jishah.pwsspringbootdemo.dao.EmployeeDao;
import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import com.pivotal.jishah.pwsspringbootdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Fetch the employee details using employee's ID
     *
     * @param employeeId@return Employee object
     */
    @Override
    public Optional<Employee> getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    /**
     * Fetch all employees from the database. If the list grows, one can use {@link Page} to get a paginated response
     *
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
