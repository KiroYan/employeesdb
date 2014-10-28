package com.epam.employeesdb.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.epam.employeesdb.dao.EmployeeDAO;
import com.epam.employeesdb.dao.OfficePositionDAO;
import com.epam.employeesdb.dao.PositionDAO;
import com.epam.employeesdb.dao.impl.EmployeeDAOImpl;
import com.epam.employeesdb.dao.impl.OfficePositionDAOImpl;
import com.epam.employeesdb.dao.impl.PositionDAOImpl;
import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.model.OfficePosition;

public class EmployeeTest {
	
	private PositionDAO positionDAO = new PositionDAOImpl();
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	private OfficePositionDAO officePositionDAO = new OfficePositionDAOImpl();

	//@Test
	public void testCreate() {
		Employee empl = TestsUtils.createSampleEmployee();
		employeeDAO.create(empl);
		
		Assert.assertNotNull(empl.getId());	
	}
	
	//@Test
	public void testGet() {
		Employee empl = TestsUtils.createSampleEmployee();
		employeeDAO.create(empl);
		
		Employee persisted = employeeDAO.get(empl.getId());
		System.out.println(persisted);
	}
	//@Test
	public void testCount() {
		OfficePosition officePositions = officePositionDAO.get(41);
		officePositionDAO.create(officePositions);
		int i = employeeDAO.getNumberOfEmployeesInOffice(officePositions.getOffice().getId());
		System.out.println(i);
	}
	
	//@Test 
	public void fillDBWithEmployees() {
		Random rn = new Random();
		List<OfficePosition> officePositions = TestsUtils.createSomeOfficePositions();
		for (int i = 0; i < 10000; i++) {
			int j = i % 50;
			Employee empl = TestsUtils.createSampleEmployee();
			empl.getOfficePositions().clear();
			empl.getOfficePositions().add(officePositions.get(rn.nextInt(50)));
			empl.getOfficePositions().add(officePositions.get(rn.nextInt(50)));
			employeeDAO.create(empl);
		}
	}
	
	//@Test
	public void testCountAllEmployees() {
		int numberOfEmployees = employeeDAO.getNumberOfEmployees();
		
		Assert.assertEquals(500, numberOfEmployees);
	}
	
	@Test
	public void get() {
		employeeDAO.getPaginated(1, 2);
		
	}

	
	
	/* */
	
}
