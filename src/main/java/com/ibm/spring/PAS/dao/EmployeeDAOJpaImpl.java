package com.ibm.spring.PAS.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.spring.PAS.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id =: empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}
