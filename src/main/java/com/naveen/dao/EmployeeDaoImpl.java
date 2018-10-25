package com.naveen.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.naveen.model.Employee;

@Component
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	HibernateTemplate template;  
	
	/*public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}*/
	
	public void addEmployee(Employee employee) {
		template.save(employee);
		
	}

	public void updateEmployee(Employee employee) {
		template.update(employee);
		
	}

	public List<Employee> getEmployees() {
		List<Employee> list=new ArrayList<Employee>();  
	    list=template.loadAll(Employee.class);  
	    return list;  
	}

	public Employee getEmployeeById(int id) {
		 Employee e=(Employee)template.get(Employee.class,id);  
		  return e; 
		  
	}

	public void deleteEmployee(int id) {
		Employee e=(Employee)template.get(Employee.class,id);   
		template.delete(e);  
		
	}

}
