package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService empService;

	@RequestMapping(value= "/search", method=RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView mv = new ModelAndView("search");
		return mv;
	}

	@RequestMapping(value = "/searchEmployee" , method=RequestMethod.GET)
	public ModelAndView employeeSearchByName(@RequestParam("empName") String empName) {
		ModelAndView m = new ModelAndView("viewEmployeeDetails");
		Employee emp = empService.getEmployeeByName(empName);
		m.addObject("employeeId",emp.getEmpId());
		m.addObject("firstName",emp.getFirstName());
		m.addObject("lastName",emp.getLastName());
		m.addObject("hiredDate",emp.getHireDate());
		m.addObject("email",emp.getEmail());
		m.addObject("address",emp.getAddress());
		m.addObject("phone",emp.getPhoneNumber());
		return m;
	}

	@RequestMapping(value = "/getEmployees", method=RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployees(@RequestParam("firstName") String empName) {
		return simulateSearchResult(empName);
	}

	private List<Employee> simulateSearchResult(String empName) {
		List<Employee> result = new ArrayList<Employee>();
		List<Employee> empList = empService.getEmployees();
		for (Employee emp : empList) {
			if (emp.getFirstName().toLowerCase().contains(empName.toLowerCase())) {
				result.add(emp);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/searchById/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Employee> employeeSearchById(@PathVariable("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
		Employee emp = empService.getEmployeeById(id);
		 return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	/*
	 * @RequestMapping("/search")
	 * 
	 * @ResponseBody public ModelAndView employeeSearch() { List<Employee> empList =
	 * empService.getEmployees(); ModelAndView mav = new
	 * ModelAndView("viewEmployeeDetails"); mav.addObject("empList", empList);
	 * return mav; }
	 */

}
