package com.naveen.dao;

import java.util.List;

import com.naveen.model.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public void deleteEmployee(int id);
	
}
