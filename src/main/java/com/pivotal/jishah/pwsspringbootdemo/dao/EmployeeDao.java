package com.pivotal.jishah.pwsspringbootdemo.dao;

import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import com.pivotal.jishah.pwsspringbootdemo.model.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    /**
     * Fetch the employee details using employee's ID
     *
     * @param Employee ID to be fetched
     * @return Employee object
     */
    public Optional<Employee> getEmployee(int employeeId);

    /**
     * Fetch all employees from the database. If the list grows, one can use {@link org.springframework.data.domain.Page} to get a paginated response
     *
     * @return
     */
    public List<Employee> getAllEmployees();

    public Employee save(EmployeeDto employee);
}
