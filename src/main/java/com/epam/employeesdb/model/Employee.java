package com.epam.employeesdb.model;

import java.util.HashSet;
import java.util.Set;


public class Employee extends AbstractEntity {
	private String firstName;
	private String lastName;
	private Address address;
	private Set<OfficePosition> officePositions;
	
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

	public Set<OfficePosition> getOfficePositions() {
		if (officePositions == null) {
			officePositions = new HashSet<>();
		}
		return officePositions;
	}

	public void setOfficePositions(Set<OfficePosition> officePositions) {
		this.officePositions = officePositions;
	}

	public String toString() {
		return firstName + ", " + lastName
				+ ", " + address + ", "
				+ officePositions;
	}
}
