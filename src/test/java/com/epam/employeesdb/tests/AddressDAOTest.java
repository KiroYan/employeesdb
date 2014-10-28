package com.epam.employeesdb.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.employeesdb.dao.AddressDAO;
import com.epam.employeesdb.dao.impl.AddressDAOImpl;
import com.epam.employeesdb.model.Address;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Country;

public class AddressDAOTest {
	private	AddressDAO addressDAO = new AddressDAOImpl();
	
	//@Test
	public void testPaginated() {
		List<Address> addresses= addressDAO.getPaginated(0, 1000);
		
		Assert.assertNotNull(addresses.get(2).getCity().getCountry());
		Assert.assertTrue(addresses.size() <= 1000);
	}
	
	//@Test
	public void testCreate() {
		Address address = TestsUtils.createSampleAddress();
		addressDAO.create(address);
	
		
		Assert.assertNotNull(addressDAO.get(address.getId()));
	}
}
