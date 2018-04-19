package com.springmvc.bean;

public class Employee {

	private int empId;
	private String name;
	private Long salary;
	private int age;
	
	public Employee() {
	}
	public Employee(int empId, String name, Long salary, int age){
		this.empId = empId;
		this.salary = salary;
		this.name = name;
		this.age = age;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
