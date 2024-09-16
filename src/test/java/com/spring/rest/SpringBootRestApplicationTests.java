package com.spring.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.rest.model.Employee;
import com.spring.rest.repository.EmployeeRepository;
import com.spring.rest.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRestApplicationTests {

	@Autowired
	private EmployeeService employeeService;
	@MockBean
	private EmployeeRepository employeeRepo;
//	@Test
//	public void contextLoads() {
//	}
//	@Test
//	public void testCount()
//	{
//		assertEquals(3,2+2);
//	}
	@Test
	public void getEmployeeTest()
	{
		when(employeeRepo.findAll()).thenReturn(Stream
				.of(new Employee(),new Employee()).collect(Collectors.toList()));
		assertEquals(2,employeeService.getAllEmployeeList().size());
	}

}
