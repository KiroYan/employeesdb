package com.epam.employeesdb.util;

import java.util.ArrayList;
import java.util.List;

import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.model.EmployeeRepresentation;
import com.epam.employeesdb.model.OfficePosition;

public class ModelToJspConvertor {
	public static  EmployeeRepresentation toJspBean(Employee employee) {
		EmployeeRepresentation employeeRepresentation = new EmployeeRepresentation();
		
		employeeRepresentation.setAddress(employee.getAddress());
		employeeRepresentation.setFirstName(employee.getFirstName());
		employeeRepresentation.setLastName(employee.getLastName());
		List<OfficePosition> officePositions = new ArrayList<>(employee.getOfficePositions());
		employeeRepresentation.setOfficePositions(officePositions);
		
		return employeeRepresentation;
	}
	
	public static List<EmployeeRepresentation> convertEmployeeListToJspBean(List<Employee> employees) {
		if (employees == null) {
			
		}
		List<EmployeeRepresentation> employeeRepresentations = new ArrayList<>();
		
		for (int i = 0; i < employees.size(); i++) {
			employeeRepresentations.add(toJspBean(employees.get(i)));
		}
		
		return employeeRepresentations;
	}
}
