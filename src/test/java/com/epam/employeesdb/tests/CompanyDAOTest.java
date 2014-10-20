/*package com.epam.employeesdb.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.epam.employeesdb.dao.CompanyDAO;
import com.epam.employeesdb.dao.impl.CompanyDAOImpl;
import com.epam.employeesdb.model.Address;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Company;
import com.epam.employeesdb.model.Country;

public class CompanyDAOTest {
	private	CompanyDAO companyDAO = new CompanyDAOImpl();

	
	//@Test
	public void testCreate() {
		Company company = TestsUtils.createSampleCompany();
		
		companyDAO.create(company);
		
		Assert.assertNotNull(companyDAO.get(company.getId()));
	}
	
	//@Test
		public void testGet() {
		
		Company company = companyDAO.get(6);
		Set<Address> addresses = company.getAddresses();
		Iterator it = addresses.iterator();
		while (it.hasNext()) {
			System.out.println((Address)it.next());
		}
		System.out.println(company.getAddresses().isEmpty());
			Assert.assertNotNull(company);
		}
		
		//@Test
		public void testPaginated() {
			List<Company> companies= companyDAO.getPaginated(0, 5);
			System.out.println(companies.get(2).getAddresses());
			
			
			Assert.assertTrue(companies.size() <= 5);
		}
		
		//@Test
		public void testDelete() {
			Company company = TestsUtils.createSampleCompany();
			
			companyDAO.create(company);
			
			Assert.assertNotNull(companyDAO.get(company.getId()));
			
			companyDAO.delete(2);
			
			Assert.assertNull(companyDAO.get(2));
		}
}
*/