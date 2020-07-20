package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Employee;


public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee(); 
		emp.setEmpId(rs.getInt("employee_id"));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setHireDate(rs.getDate("hire_date"));
		emp.setEmail(rs.getString("email"));
		emp.setPhoneNumber(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));
		emp.setJobId(rs.getString("job_id"));
		emp.setAddress(rs.getString("address"));
		return emp;
	}
}
