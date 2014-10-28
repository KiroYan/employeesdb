package com.epam.employeesdb.dao;

import com.epam.employeesdb.model.Employee;

public interface EmployeeDAO extends EntityDAO<Employee> {
	int getNumberOfEmployeesInOffice(int officeId);
	int getNumberOfEmployees();
}
