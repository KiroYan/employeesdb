package com.epam.employeesdb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.employeesdb.dao.EmployeeDAO;
import com.epam.employeesdb.dao.impl.EmployeeDAOImpl;
import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.model.EmployeeRepresentation;
import com.epam.employeesdb.model.OfficePosition;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	public List<Employee> getPaginated(int offset, int size) {
		return employeeDAO.getPaginated(offset, size);
	}

	public int getNumberOfEmployeesInOffice(int officeId) {
		return employeeDAO.getNumberOfEmployeesInOffice(officeId);
	}

	public int getNumberOfEmployees() {
		return employeeDAO.getNumberOfEmployees();
	}
	
	public Map<Integer,Integer> getNumberOfEmployeesPerOffice(List<EmployeeRepresentation> employees) {
		Map<Integer,Integer> numberOfEmployeesInOffice = new HashMap<>();
		for (int i = 0; i < employees.size(); i ++) {
			EmployeeRepresentation employee = employees.get(i);
			for (OfficePosition offPos : employee.getOfficePositions()) {
				if (!(numberOfEmployeesInOffice.containsKey(offPos.getOffice().getId()))) {
					Integer NumberOfEmployeesInOffice = getNumberOfEmployeesInOffice(offPos.getOffice().getId());
					numberOfEmployeesInOffice.put(offPos.getOffice().getId(), NumberOfEmployeesInOffice);
				}
			}
		}
		return numberOfEmployeesInOffice;
	}
}
