package com.naveen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naveen.dao.EmployeeDao;
import com.naveen.dao.EmployeeDaoImpl;
import com.naveen.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	@Autowired
	EmployeeDao employeeDao;
	/*public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}*/

	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}

	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
		
	}

	public Employee getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

	

}
