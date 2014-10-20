package com.epam.employeesdb.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.epam.employeesdb.dao.CompanyDAO;
import com.epam.employeesdb.model.Address;
import com.epam.employeesdb.model.Company;

public class CompanyDAOImpl extends AbstractEntityDAO<Company> implements
		CompanyDAO {

	public CompanyDAOImpl() {
		super(Company.class);
	}

	@Override
	public List<Company> getPaginated(int offset, int size) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Company");
		q.setFirstResult(offset);
		q.setMaxResults(size);
		List<Company> result = q.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public Company get(Integer id) {
		Company company = null;
		Session session = getConfiguredSessionFactory().openSession();
		try {
			session.beginTransaction();
			company = (Company) session.get(Company.class, id);
		} finally {

			session.getTransaction().commit();
			session.close();
		}

		return company;
	}
}
