package com.epam.employeesdb.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.employeesdb.dao.CityDAO;
import com.epam.employeesdb.dao.impl.CityDAOImpl;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Country;

public class CityDAOTest {
	private CityDAO cityDAO = new CityDAOImpl();
	
	//@Test
	public void testGet() {
	
		City city = cityDAO.get(205);
		Assert.assertNotNull(city);
	}
	
	//@Test
	public void testCreate() {
		City city = TestsUtils.createSampleCity();
		cityDAO.create(city);
		
		Assert.assertNotNull(city.getCountry().getId());
		Assert.assertNotNull(city.getId());
		
	}
	
	//@Test
	public void testCreateList() {
		Country country = new Country();
		country.setName("Sweeden");
		List<City> cities = new ArrayList<City>();
		for (int i = 0; i < 10; i ++) {
			City city = new City();
			city.setName("London " + i );
			city.setCountry(country);
			cities.add(city);
		}
		
		cityDAO.create(cities);
		
		Assert.assertNotNull(cityDAO.get(cities.get(2).getId()));
	}
	
	//@Test
	public void testPaginated() {
		List<City> cities= cityDAO.getPaginated(0, 10);
		
		Assert.assertTrue(cities.size() <= 10);
	}
	
	//@Test
	public void testDelete() {
		City city = TestsUtils.createSampleCity();
		
		cityDAO.create(city);
		
		Assert.assertNotNull(cityDAO.get(city.getId()));
		
		cityDAO.delete(city.getId());
		
		Assert.assertNull(cityDAO.get(city.getId()));
	}
}
