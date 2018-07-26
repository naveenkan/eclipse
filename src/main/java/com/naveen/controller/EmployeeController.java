package com.naveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naveen.model.Employee;
import com.naveen.service.EmployeeService;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	} */

	@RequestMapping("/empform")  
    public ModelAndView showform(){  
        return new ModelAndView("empform","command",new Employee());  
    }
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee){
		System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getSalary()+" "+employee.getDesignation());;
		employeeService.addEmployee(employee);
		System.out.println("Hello this is controller");
		 return new ModelAndView("redirect:/viewemp");
		}
	@RequestMapping("/viewemp") 
    public ModelAndView viewemp(){  
        List<Employee> list=employeeService.getEmployees();  
        return new ModelAndView("viewemp","Employeelist",list);  
    }
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
	public ModelAndView delete(@PathVariable int id){  
	        employeeService.deleteEmployee(id); 
	        return new ModelAndView("redirect:/viewemp");  
	    }
	@RequestMapping(value="/editemp/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id){
		  Employee emp=employeeService.getEmployeeById(id);  
	        return new ModelAndView("empeditform","command",emp);
		
	}
	
	   @RequestMapping(value="/editsave",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Employee emp){  
	        employeeService.updateEmployee(emp); 
	        return new ModelAndView("redirect:/viewemp");  
	    } 
	
	}
