package com.example.demo.vo;

public class Employee {
	
	private String id;
	private String login;
	private String name;
	private double salary;
	
	public Employee() {
		
	}
	public Employee(String id, String login, String name, double salary) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
