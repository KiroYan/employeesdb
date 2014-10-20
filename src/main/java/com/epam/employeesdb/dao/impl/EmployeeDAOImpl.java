package com.epam.employeesdb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.epam.employeesdb.dao.EmployeeDAO;
import com.epam.employeesdb.model.Employee;

public class EmployeeDAOImpl extends AbstractEntityDAO<Employee> implements EmployeeDAO {
	
	public static final String EMP_BY_ID_QUERY = "select emp "
			+ "from Employee emp "
			+ "join fetch emp.address as empAddress "
			+ "join fetch empAddress.city as empCity "
			+ "join fetch empCity.country as empCountry "
			+ "join fetch emp.officePositions as officePos "
			+ "join fetch officePos.office as off "
			+ "join fetch off.company as company "
			+ "join fetch off.address as offAddress "
			+ "join fetch offAddress.city as offCity "
			+ "join fetch offCity.country as offCountry "
			+ "join fetch officePos.position as pos "
			+ "where emp.id=:id";
	
	public static final String SELECT_EMP_QUERY = "select emp "
			+ "from Employee emp "
			+ "join fetch emp.address as empAddress "
			+ "join fetch empAddress.city as empCity "
			+ "join fetch empCity.country as empCountry "
			+ "join fetch emp.officePositions as officePos "
			+ "join fetch officePos.office as off "
			+ "join fetch off.company as company "
			+ "join fetch off.address as offAddress "
			+ "join fetch offAddress.city as offCity "
			+ "join fetch offCity.country as offCountry "
			+ "join fetch officePos.position as pos";
	
	public static final String SELECT_COUNT_EMP_QUERY = "select count(distinct emp.id)" 
	+ "from Employee as emp "
	+ "join  emp.officePositions as officePos "
	+ "join  officePos.office as off "
	+ "where off.id=:id";
	
	public EmployeeDAOImpl() {
		super(Employee.class);
	}
	
	

	@Override
	public Employee get(Integer id) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(EMP_BY_ID_QUERY);
		query.setParameter("id", id);
		Employee employee = (Employee) query.list().get(0);
		session.getTransaction().commit();
		session.close();
		return employee;
	}



	@Override
	public List<Employee> getPaginated(int offset, int size) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery(SELECT_EMP_QUERY);
		q.setFirstResult(offset);
		q.setMaxResults(size);
		List<Employee> result = q.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	public int getNumberOfEmployeesInOffice(int officeId) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(SELECT_COUNT_EMP_QUERY);
		query.setParameter("id", officeId);
		int numberOfEmployeesInOffice = ((Long)query.uniqueResult()).intValue();
		
		return numberOfEmployeesInOffice;
	}
}
