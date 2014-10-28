package com.epam.employeesdb.services;

import java.util.List;
import java.util.Map;

import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.model.EmployeeRepresentation;

public interface EmployeeService {
	List<Employee> getPaginated(int offset, int size);
	int getNumberOfEmployeesInOffice(int officeId);
	int getNumberOfEmployees();
	Map<Integer,Integer> getNumberOfEmployeesPerOffice(List<EmployeeRepresentation> employees);
}
