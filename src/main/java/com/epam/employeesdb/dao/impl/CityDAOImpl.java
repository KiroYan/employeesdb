package com.epam.employeesdb.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.epam.employeesdb.dao.CityDAO;
import com.epam.employeesdb.model.City;

public class CityDAOImpl extends AbstractEntityDAO<City> implements CityDAO {

	public CityDAOImpl() {
		super(City.class);
	}
	
	@Override
	public List<City> getPaginated(int offset, int size) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("select c from City c join c.country");
		q.setFirstResult(offset);
		q.setMaxResults(size);
		List<City> result = q.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
}
