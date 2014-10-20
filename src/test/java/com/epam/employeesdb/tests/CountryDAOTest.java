package com.epam.employeesdb.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.employeesdb.dao.CityDAO;
import com.epam.employeesdb.dao.CountryDAO;
import com.epam.employeesdb.dao.impl.CityDAOImpl;
import com.epam.employeesdb.dao.impl.CountryDAOImpl;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Country;

public class CountryDAOTest {
	private CountryDAO countryDAO = new CountryDAOImpl();

	//@Test
	public void testGet() {

		Country country = countryDAO.get(255);
		Assert.assertNotNull(country);
	}

	//@Test
	public void testCreate() {
		
		
		Country country = TestsUtils.createSampleCountry();


		countryDAO.create(country);

		Assert.assertNotNull(country.getId());
	}

	// @Test
	public void testPaginated() {
		List<Country> countries = countryDAO.getPaginated(0, 10);

		Assert.assertTrue(countries.size() <= 10);
	}
	
	//@Test
	public void testDelete() {
		Country country = TestsUtils.createSampleCountry();
		
		countryDAO.create(country);
		Assert.assertNotNull(countryDAO.get(country.getId()));
		
		countryDAO.delete(country.getId());
		
		Assert.assertNull(countryDAO.get(country.getId()));
	}
}
