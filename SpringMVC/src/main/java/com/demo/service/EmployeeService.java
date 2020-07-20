package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {
	 Employee getEmployeeByName(String empName);
	
	 List<Employee> getEmployees();
	
	 Employee getEmployeeById(int id);

}
