package com.epam.employeesdb.dao.impl;
/*package com.epam.employeesdb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.employeesdb.model.Address;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Company;
import com.epam.employeesdb.model.Country;
import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.util.HibernateUtil;

public class DAOImpl implements EntityDAO {
	
	private static SessionFactory sessionFactory = HibernateUtil.buildAndConfigureSessionFactory();
	
	public Country getCountry() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Country country = (Country)session.get(Country.class, 23);
		session.getTransaction().commit();
		session.close();

		return country;
	}
	
	public void addCountry(Country country) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(country);
		session.getTransaction().commit();
		session.close();
	}
	
	public void addCountriesList (List<Country> countries) {
		if (countries == null) {
			throw new IllegalArgumentException("null is bad argument!");
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < countries.size(); i++) {
			session.save(countries.get(i));
			if (i % 20 == 0) {
				session.flush();
		        session.clear();
		        System.out.println("flushed");
			}
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public void addCitiesList (List<City> cities) {
		if (cities == null) {
			throw new IllegalArgumentException("null is bad argument!");
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < cities.size(); i++) {
			session.save(cities.get(i));
			if (i % 20 == 0) {
				session.flush();
		        session.clear();
		        System.out.println("flushed");
			}
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public void addAddressList(List<Address> addresses) {
		if (addresses == null) {
			throw new IllegalArgumentException("null is bad argument!");
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < addresses.size(); i++) {
			session.save(addresses.get(i));
			if (i % 20 == 0) {
				session.flush();
		        session.clear();
		        System.out.println("flushed");
			}
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Object[]> getPortionOfAddresses() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Address addr join addr.city as cit join cit.country");
		q.setFirstResult(1);
		q.setMaxResults(10);
		List<Object[]> addresses = q.list();
		session.getTransaction().commit();
		session.close();
		return addresses;
	}
	
	public City getCity() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		City city = (City)session.get(City.class, 1);
		session.getTransaction().commit();
		session.close();
		
		return city;
	}
	
	public Address getAddress(Integer id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Address address = (Address)session.get(Address.class, id);
		session.getTransaction().commit();
		session.close();
		
		return address;
	}
	
	public Employee getEmployee() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = (Employee)session.get(Employee.class, 3);
		session.getTransaction().commit();
		session.close();
		
		return employee;
	}
	
	public void addCompany(Company company) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(company);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Object[]> getEmployees() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		sess.createSQLQuery("SELECT employee_id, company_address_id, position_id FROM employee_company").list();
		 * 
		 * 
		 * 
		 * 
		
		
		
		Query q = session.createQuery("from  addr join addr.city as cit join cit.country");
		q.setFirstResult(1);
		q.setMaxResults(10);
		List<Object[]> addresses = q.list();
		session.getTransaction().commit();
		session.close();
		
		return null;
	}
}
*/