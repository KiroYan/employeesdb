package com.epam.employeesdb.model;

public class Office extends AbstractEntity {
	private Company company;
	private Address address;
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return company + ", " + address + ", ";
	}
}
