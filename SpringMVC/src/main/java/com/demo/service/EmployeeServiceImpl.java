package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDao;
	
	public Employee getEmployeeByName(String empName) {
		Employee emp = employeeDao.getEmployeeByName(empName);
		return emp;
	}

	public List<Employee> getEmployees() {
		List<Employee> empList = employeeDao.getEmployees();
		return empList;
	}

	public Employee getEmployeeById(int id) {
		Employee employee = employeeDao.getEmployeeById(id);
		return employee;
	}



}
