package com.pivotal.jishah.pwsspringbootdemo.repository;

import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void init() {
        Employee employee = new Employee("John", "Pivotal-Labs", "Toronto");
        employeeRepository.save(employee);
        employee = new Employee("Jimmy", "Pivotal-Labs", "Toronto");
        employeeRepository.save(employee);
    }

    @Test
    public void testGetAllEmployees() {
        Assert.assertEquals(2, employeeRepository.findAll().size());
    }

    @Test
    public void testGetEmployeeByName() {
        Assert.assertNotNull(employeeRepository.findByName("John"));
        Assert.assertNotNull(employeeRepository.findByName("Jimmy"));
    }
}
