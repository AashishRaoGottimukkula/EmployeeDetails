package com.Task.EmployerDetails.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Task.EmployerDetails.Employee;
import com.Task.EmployerDetails.Service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> getEmployeeDetails(
			@RequestParam(name = "prefix", required = false) String prefix,
            @RequestParam(name = "sortType", required = false) String sortType) {
		return employeeService.getEmployeeDetails(prefix, sortType);
	}
}

