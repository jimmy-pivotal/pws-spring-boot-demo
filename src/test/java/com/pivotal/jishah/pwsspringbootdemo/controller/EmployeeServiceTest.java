package com.pivotal.jishah.pwsspringbootdemo.controller;

import com.pivotal.jishah.pwsspringbootdemo.dao.EmployeeDao;
import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeDao employeeDao;

    @Test
    public void testFindAllEmployees() throws Exception {
        Employee employee = new Employee("John", "Pivotal-Labs", "Toronto");
        List<Employee> employees = Arrays.asList(employee);
        given(employeeDao.getAllEmployees()).willReturn(employees);

        mvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("John")));
    }

    @Test
    public void testFindEmployeeById() throws Exception {
        Employee employee = new Employee("John", "Pivotal-Labs", "Toronto");
        given(employeeDao.getEmployee(0)).willReturn(Optional.of(employee));

        mvc.perform(get("/employee/0"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("John")));

        mvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
