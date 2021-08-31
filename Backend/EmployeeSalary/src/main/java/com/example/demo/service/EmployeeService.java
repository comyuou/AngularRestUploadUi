package com.example.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.vo.Employee;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDAO;
	
	private List<Employee> lst=new ArrayList<Employee>();
	public List<Employee> getLst() {
		return lst;
	}
	EmployeeService(){
		lst.add(new Employee("1","user1", "John", 4000.00));
		lst.add(new Employee("2","user2", "Jane", 5500.50));
	}
	
	public static Stream<String> getStreams(String filePath) throws IOException {
		Stream<String> stream = Files.lines(Paths.get(filePath),StandardCharsets.UTF_8);
		//stream.skip(1).filter(s->!s.startsWith("#")).forEach(System.out::println);
		stream=stream.skip(1).filter(s->!s.startsWith("#"));
		return stream;
	}
	

	
	public List<Employee> getEmployees() {
		System.out.println("IN GETEMPLOYEES");
		List<Employee> lst = new ArrayList<Employee>();
		try {
			Stream<String> stream = 
					getStreams("D:\\EclipseNew\\EmployeeSalary\\src\\main\\resources\\sample.txt");
			lst=stream.map((str)->{
				String values[]=str.split(",");
				return new Employee(values[0],values[1],values[2],Double.parseDouble(values[3]));			
			}).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	public List<Employee> getEmployees(double minSalary,double maxSalary, int offset, int limit, String sort) {
		List<Employee> lst = new ArrayList<Employee>();
		System.out.println(sort);
		String sortType=sort.charAt(0)+"";
		String columnName=sort.substring(1);
		lst= employeeDAO.getEmployee(minSalary, maxSalary,columnName,sortType);	
		lst=lst.subList(offset,limit+1 > lst.size() ? lst.size() : limit+1);
		return lst;
	}
	public void insertDetails() {
		System.out.println("IN SERVICE INSERT DETAILS");
		employeeDAO.insertDetails(getEmployees());
	}
}
