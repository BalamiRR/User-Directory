package com.fuatkara.thymeleaf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.fuatkara.thymeleaf.dao.EmployeeRepository;
import com.fuatkara.thymeleaf.entity.Employee;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeServiceTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	// Finding All Test
	@Test
	public void getAllEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		Employee empOne = new Employee(1, "John", "Johnness", "johns@gmail.com");
		Employee empTwo = new Employee(2, "Jack", "Sparrow", "jack@gmail.com");
		Employee empThree = new Employee(2, "Edward", "Scissorhand", "edward@gmail.com");
	
		list.add(empOne);
		list.add(empTwo);
		list.add(empThree);
		
		when(employeeRepository.findAll()).thenReturn(list);
		
		//Test
		List<Employee> empList = employeeServiceImpl.findAll();
		
		assertEquals(3, empList.size());
		verify(employeeRepository, times(1)).findAll();
	
	}
	
	// Insert Test
	@Test
	public void createEmployeeTest(){		
		
		Employee emp = new Employee(1, "Zlatan", "Ibrahimovic", "zlatan@gmail.com");
		
		employeeServiceImpl.save(emp);
		
		verify(employeeRepository, times(1)).save(emp);	
		
	}
	
	// Finding By Id Test
	@Test
	public void employeeByIdTest() {
		
		Employee person = new Employee("Fuat","Kara","user@gmail.com");
		
		Mockito.when(employeeRepository.findById(1))
		.thenReturn(Optional.of(person)); 
		
		//Test
		Employee emp = employeeServiceImpl.findById(1);
		
		assertEquals("Fuat", emp.getFirstName());
		assertEquals("Kara", emp.getLastName());
		assertEquals("user@gmail.com", emp.getEmail());
		
	}
	
		
}