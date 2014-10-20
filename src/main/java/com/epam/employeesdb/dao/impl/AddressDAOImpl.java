package com.epam.employeesdb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.epam.employeesdb.dao.AddressDAO;
import com.epam.employeesdb.model.Address;

public class AddressDAOImpl extends AbstractEntityDAO<Address> implements AddressDAO {

	public AddressDAOImpl() {
		super(Address.class);
	}

	@Override
	public List<Address> getPaginated(int offset, int size) {
		Session session = getConfiguredSessionFactory().openSession();
		session.beginTransaction();
		Query q = session.createQuery("select a from Address a join  a.city  join fetch  a.city.country");
		q.setFirstResult(offset);
		q.setMaxResults(size);
		List<Address> result = q.list();
		/*for (int i = 0; i < result.size(); i ++) {
			Hibernate.initialize(result.get(i).getCity().getCountry());
		}*/
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	

}
