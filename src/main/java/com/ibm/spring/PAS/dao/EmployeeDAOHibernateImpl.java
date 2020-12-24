package com.ibm.spring.PAS.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.spring.PAS.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	
	// 類似JDBC在對資料庫操作之前，必須先取得Connection實例，EntityManager是JPA操作的基礎
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query =
				session.createQuery("from Employee",Employee.class);
		
		// execute query and get results
		List<Employee> employees = query.getResultList();
		
		// return results
		return employees;
		
	}

	@Override
	public Employee findById(int id) {
		return getSession().get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		getSession().saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Query query = getSession().createQuery("delete from Employee where id =: empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}


	
}
