package com.ibm.spring.PAS.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

//import com.ibm.spring.PAS.dao.EmployeeDAO;
import com.ibm.spring.PAS.dao.EmployeeRepository;
import com.ibm.spring.PAS.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		System.out.println("findById");
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}

// 原生JPA
//private EmployeeDAO employeeDAO;
//
//@Autowired
//public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO) {
//	employeeDAO = theEmployeeDAO;
//}
//
//@Override
//@Transactional
//public List<Employee> findAll() {
//	return employeeDAO.findAll();
//}
//
//@Override
//@Transactional
//public Employee findById(int theId) {
//	return employeeDAO.findById(theId);
//}
//
//@Override
//@Transactional
//public void save(Employee theEmployee) {
//	employeeDAO.save(theEmployee);
//}
//
//@Override
//@Transactional
//public void deleteById(int theId) {
//	employeeDAO.deleteById(theId);
//}


// 原生Hibernate
//private EmployeeDAO employeeDAO;
//
//@Autowired
//public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
//	employeeDAO = theEmployeeDAO;
//}
//
//@Override
//@Transactional
//public List<Employee> findAll() {
//	return employeeDAO.findAll();
//}
//
//@Override
//@Transactional
//public Employee findById(int theId) {
//	return employeeDAO.findById(theId);
//}
//
//@Override
//@Transactional
//public void save(Employee theEmployee) {
//	employeeDAO.save(theEmployee);
//}
//
//@Override
//@Transactional
//public void deleteById(int theId) {
//	employeeDAO.deleteById(theId);
//}

