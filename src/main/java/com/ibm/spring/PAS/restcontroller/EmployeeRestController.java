package com.ibm.spring.PAS.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ibm.spring.PAS.dao.EmployeeDAO;
import com.ibm.spring.PAS.entity.Employee;
import com.ibm.spring.PAS.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//	此處直接呼叫DAO，可能會有風險，故轉交給Service處理邏輯及風險管理，再呼叫DAO
//	private EmployeeDAO employeeDAO;
//
//	@Autowired
//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
//		employeeDAO = theEmployeeDAO;
//	}

	private EmployeeService employeeService ;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/employee")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {
		Employee employee = employeeService.findById(empId);
		if(employee == null) {
			System.out.println("Emp id not found");
			throw new RuntimeException("Emp id not found: "+empId);
		}
		return employee;
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	// when add mapping for Put --> update existing data
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		Employee employee = employeeService.findById(empId);
		if(employee == null) {
			throw new RuntimeException("Emp id is not found: "+empId);
		}
		employeeService.deleteById(empId);
		return "Delete emp id: "+empId;
	}
	
}
