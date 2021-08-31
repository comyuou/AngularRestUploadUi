package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;
import com.example.demo.vo.Employee;

@CrossOrigin
@RestController
public class EmployeeSalaryController {
	@Autowired
	EmployeeService empService;
	/*@GetMapping("/employees")
	public List<Employee> getEmployee() {
		
		return empService.getLst();
	}*/
	@GetMapping("/employees/{id}")
	public Employee getEmployee1(@PathVariable("id") String id) {
		return empService.getLst()
				.stream()
				.filter(p->p.getId().equals(id))
				.collect(Collectors.toList()).get(0);
		
	}
	@PostMapping("/employee")
	public void addPerson(@RequestBody Employee emp) {
		empService.getLst().add(emp);
	}
	
	@PostMapping("/employees/upload")
	public void insertDetails(){
		System.out.println("IN CONTROLLER");
		empService.insertDetails();
	}
	
	@GetMapping("/users")
	public List<Employee> sortEmployee
	(@RequestParam("minSalary") double minSalary, @RequestParam("maxSalary") double maxSalary, 
			@RequestParam("offset") int offset,@RequestParam("limit") int limit, @RequestParam("sort")
			String sort)
	{
		return empService.getEmployees(minSalary, maxSalary, offset, limit, sort);
	}
}
