package com.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Employee getEmployeeByName(String name) {
		String sql = "select * from employees where first_name = "+"'"+name+"'";
		Employee emp = template.queryForObject(sql, new EmployeeMapper());
		return emp;
	}

	
	public List<Employee> getEmployees() {
		String sql = "select * from employees";
		List<Employee> employees = template.query(sql, new EmployeeMapper());
		return employees;
	}

	public Employee getEmployeeById(int id) {
		String sql = "select * from employees where employee_id ="+id;
		Employee emp = template.queryForObject(sql, new EmployeeMapper());
		return emp;
	}

}
