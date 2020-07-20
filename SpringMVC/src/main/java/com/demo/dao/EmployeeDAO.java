package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDAO {

	Employee getEmployeeByName(String empName);

	List<Employee> getEmployees();

	Employee getEmployeeById(int id);

}
