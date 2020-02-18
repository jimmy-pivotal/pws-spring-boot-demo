package com.pivotal.jishah.pwsspringbootdemo;

import com.pivotal.jishah.pwsspringbootdemo.model.Employee;
import com.pivotal.jishah.pwsspringbootdemo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = PwsSpringBootDemoApplication.class)
@AutoConfigureMockMvc
class PwsSpringBootDemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void test_givenEmployees_whenGetAllEmployees_thenStatus200() throws Exception {
		Employee john = new Employee("John", "Pivotal-Labs", "Toronto");
		Employee james =  new Employee("James", "Pivotal-Labs", "Toronto");
		employeeRepository.save(john);
		employeeRepository.save(james);
		mvc.perform(get("/employees"))
			.andExpect(status().isOk()).andDo(print())
			.andExpect(jsonPath("$[0].name").exists());
	}

	@Test
	public void test_givenEmployees_whenGetEmployeeById_thenStatus200() throws Exception {
		Employee john = new Employee("Jimmy", "Pivotal-Labs", "Toronto");
		employeeRepository.save(john);
		mvc.perform(get("/employee/3"))
				.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("name").exists());
	}
}
