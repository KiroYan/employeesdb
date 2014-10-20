package com.epam.employeesdb.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.epam.employeesdb.dao.CountryDAO;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Country;

public class CountryDAOImpl extends AbstractEntityDAO<Country> implements CountryDAO {
	
	public CountryDAOImpl() {
		super(Country.class);
	}

	@Override
	public List<Country> getPaginated(int offset, int size) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Country");
		q.setFirstResult(offset);
		q.setMaxResults(size);
		List<Country> result = q.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	
}
