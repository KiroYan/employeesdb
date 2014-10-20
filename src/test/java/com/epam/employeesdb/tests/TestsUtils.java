package com.epam.employeesdb.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.epam.employeesdb.model.Address;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Company;
import com.epam.employeesdb.model.Country;
import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.model.Office;
import com.epam.employeesdb.model.OfficePosition;
import com.epam.employeesdb.model.Position;

public class TestsUtils {
	private static int counter = 1;
	public static Country createSampleCountry() {
		Country country = new Country();
		country.setName("Denmark" + (System.currentTimeMillis() % 100 ));
		
		return country;
	}
	
	public static City createSampleCity() {
		City city = new City();
		city.setName("New York" + (System.currentTimeMillis()% 100));
		city.setCountry(createSampleCountry());
		
		return city;
	}
	
	public static Address createSampleAddress() {
		Address address = new Address();
		address.setApartment(1);
		address.setHouse(2);
		address.setStreet("great street" + (System.currentTimeMillis()% 100));
		address.setCity(createSampleCity());
		
		return address;
	}
	
	public static Company createSampleCompany() {
		Company company = new Company(); 
		company.setName("Apple" + (System.currentTimeMillis() % 1000));
		
		return company;
	}
	
	public static Employee createSampleEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("John" + (System.currentTimeMillis()% 100));
		employee.setLastName("Show" + (System.currentTimeMillis()% 100));
		employee.setAddress(createSampleAddress());
		employee.setOfficePositions(new HashSet<OfficePosition>() {
			{
				add(createSampleOfficePosition());
				add(createSampleOfficePosition());
				add(createSampleOfficePosition());
			}
		});
		
		return employee;
	}
	
	public static Position createSamplePosition() {
		Position position = new Position();
		position.setName("developer" +(System.currentTimeMillis()% 100));
		
		return position;
	}
	
	public static Office createSampleOffice() {
		Office office = new Office();
		office.setCompany(createSampleCompany());
		office.setAddress(createSampleAddress());
		
		return office;
	}
	
	public static OfficePosition createSampleOfficePosition() {
		OfficePosition officePosition = new OfficePosition();
		officePosition.setPosition(createSamplePosition());
		officePosition.setOffice(createSampleOffice());
		
		return officePosition;
	}
	
	public static List<OfficePosition> getSomeOfficePositions() {
		List<OfficePosition> officePositions = new ArrayList<>();
		for (int i = 0; i <= 50; i++) {
			OfficePosition officePosition = new OfficePosition();
			officePosition.setPosition(createSamplePosition());
			officePosition.setOffice(createSampleOffice());
			officePositions.add(officePosition);
		}
		
		return officePositions;
	}
	
	
}

