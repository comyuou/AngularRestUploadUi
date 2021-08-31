package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.vo.Employee;


@Repository
public class EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	PlatformTransactionManager txManager;
	
	public void insertDetails(List<Employee> employees) {
		
		
		for(Employee emp:employees) {
			
			Employee emp1=getEmployee(emp.getId());
			if(emp1!=null) {
				jdbcTemplate.update("update employees set login=?, fname=?, salary=? where id=?",
						emp.getLogin(), emp.getName(), emp.getSalary(),emp.getId());
			}else {
			jdbcTemplate.update("insert into employees values(?,?,?,?)",
					new Object[] {emp.getId(), emp.getLogin(), emp.getName(), emp.getSalary()});
			}
		}
		
	}
	
	public Employee getEmployee(String id) {
		BeanPropertyRowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee emp1 = null;
		try {
		emp1 = jdbcTemplate.queryForObject("select * from employees where id=?", 
				rowMapper, new Object[] {id});
		}
		catch(EmptyResultDataAccessException e) {
			
		}
		return emp1;
	}
	public List<Employee> getEmployee(double minSalary,double maxSalary,String columnName,String sortType) {
		BeanPropertyRowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> emp1 = null;
		try {
			String str="";
			if(sortType.equals("-")) {
				str="select * from employees where salary>=? and salary<=? order by "+columnName+" desc";
			}else {
				str="select * from employees where salary>=? and salary<=? order by "+columnName+" asc";
			}
			emp1= jdbcTemplate.query(
					str,
					new Object[] {minSalary,maxSalary},
					new EmpMapper()
					);
		}
		catch(EmptyResultDataAccessException e) {
		}
		return emp1;
	}
}
