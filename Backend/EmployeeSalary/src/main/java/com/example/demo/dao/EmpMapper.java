package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.vo.Employee;


public class EmpMapper implements RowMapper {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Employee(rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4));
	}
}
