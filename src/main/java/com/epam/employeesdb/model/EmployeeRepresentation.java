package com.epam.employeesdb.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeRepresentation {
	private String firstName;
	private String lastName;
	private Address address;
	private List<OfficePosition> officePositions;
	private Map<Long, Integer> numberOfEmployeesInOffice;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<OfficePosition> getOfficePositions() {
		if (officePositions == null)
			officePositions = new ArrayList<>();
		return officePositions;
	}
	public void setOfficePositions(List<OfficePosition> officePositions) {
		this.officePositions = officePositions;
	}
	public Map<Long, Integer> getNumberOfEmployeesInOffice() {
		if (numberOfEmployeesInOffice == null)
			numberOfEmployeesInOffice = new HashMap<>();
		return numberOfEmployeesInOffice;
	}
	public void setNumberOfEmployeesInOffice(
			Map<Long, Integer> numberOfEmployeesInOffice) {
		this.numberOfEmployeesInOffice = numberOfEmployeesInOffice;
	}
}
