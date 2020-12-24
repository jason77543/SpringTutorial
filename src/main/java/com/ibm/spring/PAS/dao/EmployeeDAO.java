package com.ibm.spring.PAS.dao;

import java.util.List;

import com.ibm.spring.PAS.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}


